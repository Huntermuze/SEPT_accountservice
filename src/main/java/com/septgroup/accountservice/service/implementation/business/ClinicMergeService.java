package com.septgroup.accountservice.service.implementation.business;

import com.septgroup.accountservice.dto.Clinic;
import com.septgroup.accountservice.entity.ClinicPOJO;
import org.springframework.stereotype.Service;

@Service
public class ClinicMergeService {
    public ClinicPOJO clinicDTOToEntity(Clinic dto) {
        return new ClinicPOJO(dto.clinicName(), dto.location(), dto.phoneNumber());
    }

    public Clinic clinicEntityToDTO(ClinicPOJO entity) {
        return new Clinic(entity.getClinicName(), entity.getLocation(), entity.getPhoneNumber());
    }
}
