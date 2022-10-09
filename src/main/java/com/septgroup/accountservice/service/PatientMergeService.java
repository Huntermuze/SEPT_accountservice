package com.septgroup.accountservice.service;

import com.septgroup.accountservice.dto.Patient;
import com.septgroup.accountservice.dto.Prescription;
import com.septgroup.accountservice.entity.PatientPOJO;
import com.septgroup.accountservice.entity.PrescriptionPOJO;
import com.septgroup.accountservice.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientMergeService {
    @Autowired
    PrescriptionRepository prescriptionRepository;

    public Patient patientEntityToDTO(PatientPOJO entity) {
        List<Prescription> prescriptionList = new ArrayList<>();
        for (PrescriptionPOJO e : prescriptionRepository.findAllPrescriptionForPatient(entity.getId().toString())) {
            prescriptionList.add(new Prescription(e.getDrugName(), e.getQuantity(), e.getPharmaceuticalCompany()));
        }
        return new Patient(entity.getId().toString(), entity.getEmail(), entity.getFirstName(),
                entity.getLastName(), entity.getMobileNumber(), entity.getDOB(),
                prescriptionList, entity.getHealthStatus());
    }

    public PatientPOJO patientDTOToEntity(Patient dto) {
        return new PatientPOJO(UUID.fromString(dto.getId()), dto.getEmail(), dto.getFirstName(), dto.getLastName(), dto.getMobileNumber(), dto.getDOB(), dto.getHealthStatus());
    }

}
