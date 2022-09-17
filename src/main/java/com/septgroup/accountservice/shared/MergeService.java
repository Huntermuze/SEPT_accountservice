package com.septgroup.accountservice.shared;

import com.septgroup.accountservice.doctor.ClinicRepository;
import com.septgroup.accountservice.doctor.dto.Clinic;
import com.septgroup.accountservice.doctor.dto.Doctor;
import com.septgroup.accountservice.doctor.entity.ClinicPOJO;
import com.septgroup.accountservice.doctor.entity.DoctorPOJO;
import com.septgroup.accountservice.patient.PrescriptionRepository;
import com.septgroup.accountservice.patient.dto.Patient;
import com.septgroup.accountservice.patient.dto.Prescription;
import com.septgroup.accountservice.patient.entity.PatientPOJO;
import com.septgroup.accountservice.patient.entity.PrescriptionPOJO;
import com.septgroup.accountservice.shared.entity.UserPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MergeService {
    @Autowired
    ClinicRepository clinicRepository;
    @Autowired
    PrescriptionRepository prescriptionRepository;

    // TODO make it guaranteed to get a clinic object, so that we don't need optionals.
    public Optional<Doctor> doctorEntityToDTO(DoctorPOJO entity) {
        var result = clinicRepository.findById((entity).getClinicID());
        if (result.isEmpty()) {
            return Optional.empty();
        }
        ClinicPOJO clinicPOJO = result.get();
        Clinic clinic = new Clinic(clinicPOJO.getClinicID(), clinicPOJO.getClinicName(), clinicPOJO.getLocation(), clinicPOJO.getPhoneNumber());
        Doctor doc = new Doctor(entity.getId().toString(), entity.getEmail(), entity.getFirstName(),
                entity.getLastName(), entity.getSex(), entity.getMobileNumber(), clinic);
        return Optional.of(doc);
    }

    public DoctorPOJO doctorDTOToEntity(Doctor dto) {
        return new DoctorPOJO(UUID.fromString(dto.getId()), dto.getEmail(), dto.getFirstName(), dto.getLastName(),
                dto.getSex(), dto.getMobileNumber(), dto.getClinicWorkingAt().clinicID());
    }

    public Optional<Patient> patientEntityToDTO(PatientPOJO entity) {
        List<Prescription> prescriptionList = new ArrayList<>();
        for (PrescriptionPOJO e : prescriptionRepository.findAllPrescriptionForPatient(entity.getId().toString())) {
            prescriptionList.add(new Prescription(e.getId(), e.getDrugName(), e.getQuantity(), e.getPharmaceuticalCompany()));
        }
        Patient patient = new Patient(entity.getId().toString(), entity.getEmail(), entity.getFirstName(),
                entity.getLastName(), entity.getSex(), entity.getMobileNumber(), entity.getDob(),
                prescriptionList, entity.getHealthStatus());
        return Optional.of(patient);
    }

    public PatientPOJO patientDTOToEntity(Patient dto) {
        return new PatientPOJO(UUID.fromString(dto.getId()), dto.getEmail(), dto.getFirstName(), dto.getLastName(),
                dto.getSex(), dto.getMobileNumber(), dto.getDOB(), dto.getHealthStatus());
    }
}
