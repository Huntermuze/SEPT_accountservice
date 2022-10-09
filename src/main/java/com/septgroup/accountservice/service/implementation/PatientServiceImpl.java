package com.septgroup.accountservice.service.implementation;

import com.septgroup.accountservice.dto.Patient;
import com.septgroup.accountservice.dto.container.Patients;
import com.septgroup.accountservice.entity.PatientPOJO;
import com.septgroup.accountservice.exception.AlreadyExistException;
import com.septgroup.accountservice.exception.InvalidIdException;
import com.septgroup.accountservice.exception.NotFoundException;
import com.septgroup.accountservice.repository.PatientRepository;
import com.septgroup.accountservice.service.api.PatientService;
import com.septgroup.accountservice.service.api.PrescriptionService;
import com.septgroup.accountservice.service.PatientMergeService;
import com.septgroup.accountservice.util.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {
    // TODO add in LRU cache support for faster retrieval.
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientMergeService patientMergeService;
    @Autowired
    PrescriptionService prescriptionService;

    @Override
    public Patients getPatients() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().stream().map(user -> patientMergeService.patientEntityToDTO(user)).forEach(patients::add);
        return new Patients(patients);
    }

    @Override
    public Patient getPatient(String patientID) throws InvalidIdException, NotFoundException {
        UUID uuid = VerificationUtil.ifValidGetUUID(patientID);
        return patientMergeService.patientEntityToDTO(returnIfFoundElseThrow(uuid));
    }

    @Override
    public Patient getPatient(Patient patient) throws InvalidIdException, NotFoundException {
        return getPatient(patient.getId());
    }

    @Override
    public void addPatient(Patient patient) throws InvalidIdException {
        try {
            if (getPatient(patient).getId().equals(patient.getId())) {
                throw new AlreadyExistException(String.format("A patient with this id (%s) already exists!", patient.getId()));
            }
        } catch (NotFoundException | NoSuchElementException ignored) {
            patientRepository.save(patientMergeService.patientDTOToEntity(patient));
        }

        VerificationUtil.throwIfNotValid(patient.getId());
    }

    @Override
    public void updatePatient(Patient newPatient) throws InvalidIdException, NotFoundException {
        UUID uuid = VerificationUtil.ifValidGetUUID(newPatient.getId());
        PatientPOJO patientToUpdate = returnIfFoundElseThrow(uuid);
        patientToUpdate.setEmail(newPatient.getEmail());
        patientToUpdate.setDOB(newPatient.getDOB());
        patientToUpdate.setHealthStatus(newPatient.getHealthStatus());
        patientToUpdate.setFirstName(newPatient.getFirstName());
        patientToUpdate.setLastName(newPatient.getLastName());
        patientToUpdate.setMobileNumber(newPatient.getMobileNumber());
        patientRepository.save(patientToUpdate);
    }

    @Override
    public void removePatient(String patientID) throws InvalidIdException {
        UUID uuid = VerificationUtil.ifValidGetUUID(patientID);
        patientRepository.delete(returnIfFoundElseThrow(uuid));
        prescriptionService.removeAllPatientPrescriptions(uuid.toString());
    }

    public PatientPOJO returnIfFoundElseThrow(UUID patientID) throws NotFoundException {
        var result = patientRepository.findById(patientID);
        if (result.isEmpty()) {
            throw new NotFoundException(String.format("The patient (with id %s) does not exist!", patientID));
        }
        return result.get();
    }
}
