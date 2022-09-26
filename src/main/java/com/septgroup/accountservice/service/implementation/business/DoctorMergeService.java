package com.septgroup.accountservice.service.implementation.business;

import com.septgroup.accountservice.dto.Doctor;
import com.septgroup.accountservice.entity.DoctorPOJO;
import com.septgroup.accountservice.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorMergeService {
    @Autowired
    ClinicRepository clinicRepository;

    public Doctor doctorEntityToDTO(DoctorPOJO entity) {
        return new Doctor(entity.getId().toString(), entity.getEmail(), entity.getFirstName(),
                entity.getLastName(), entity.getMobileNumber(), entity.getClinicName());
    }

    public DoctorPOJO doctorDTOToEntity(Doctor dto, String clinicName) {
        return new DoctorPOJO(UUID.fromString(dto.getId()), dto.getEmail(), dto.getFirstName(), dto.getLastName(), dto.getMobileNumber(), clinicName);
    }
}
