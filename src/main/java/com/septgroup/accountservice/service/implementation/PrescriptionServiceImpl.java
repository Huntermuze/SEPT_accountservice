package com.septgroup.accountservice.service.implementation;

import com.septgroup.accountservice.dto.Prescription;
import com.septgroup.accountservice.exception.AlreadyExistException;
import com.septgroup.accountservice.exception.InvalidIdException;
import com.septgroup.accountservice.exception.NotFoundException;
import com.septgroup.accountservice.repository.PrescriptionRepository;
import com.septgroup.accountservice.service.api.PrescriptionService;
import com.septgroup.accountservice.service.implementation.business.PrescriptionMergeService;
import com.septgroup.accountservice.util.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    PrescriptionMergeService prescriptionMergeService;

    public List<Prescription> getPrescriptionsForPatient(String patientID) throws InvalidIdException {
        VerificationUtil.throwIfNotValid(patientID);
        return prescriptionRepository.findAllPrescriptionForPatient(patientID).stream()
                .map(p -> prescriptionMergeService.prescriptionEntityToDTO(p)).collect(Collectors.toList());
    }

    public List<Prescription> getPrescribedByDoctor(String doctorID) throws InvalidIdException {
        VerificationUtil.throwIfNotValid(doctorID);
        return prescriptionRepository.findAllPrescriptionForPatient(doctorID).stream()
                .map(p -> prescriptionMergeService.prescriptionEntityToDTO(p)).collect(Collectors.toList());
    }

    public void prescribeToPatient(Prescription prescription, String doctorID, String patientID) throws InvalidIdException, AlreadyExistException {
        VerificationUtil.throwIfNotValid(doctorID);
        VerificationUtil.throwIfNotValid(patientID);
        if (prescriptionRepository.findByPrescriptionDTO(prescription.drugName(),
                prescription.pharmaceuticalCompany(), prescription.quantity(), patientID, doctorID).isEmpty()) {
            throw new AlreadyExistException("This prescription already exists!");
        }
        prescriptionRepository.save(prescriptionMergeService.prescriptionDTOToEntity(prescription, doctorID, patientID));
    }

    public void removePrescription(Prescription prescription, String doctorID, String patientID) throws InvalidIdException, NotFoundException {
        VerificationUtil.throwIfNotValid(doctorID);
        VerificationUtil.throwIfNotValid(patientID);
        if (prescriptionRepository.findByPrescriptionDTO(prescription.drugName(),
                prescription.pharmaceuticalCompany(), prescription.quantity(), patientID, doctorID).isEmpty()) {
            throw new NotFoundException("This prescription does not exist!");
        }
        prescriptionRepository.delete(prescriptionMergeService.prescriptionDTOToEntity(prescription, doctorID, patientID));
    }

    public void removeAllPatientPrescriptions(String patientID) {
        VerificationUtil.throwIfNotValid(patientID);
        prescriptionRepository.deleteAll(prescriptionRepository.findAllPrescriptionForPatient(patientID));
    }

    public void removeAllDoctorPrescriptions(String doctorID) {
        VerificationUtil.throwIfNotValid(doctorID);
        prescriptionRepository.deleteAll(prescriptionRepository.findAllPrescribedByDoctor(doctorID));
    }
}
