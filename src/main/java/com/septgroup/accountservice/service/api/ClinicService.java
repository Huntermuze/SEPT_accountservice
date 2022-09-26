package com.septgroup.accountservice.service.api;

import com.septgroup.accountservice.dto.Clinic;
import com.septgroup.accountservice.dto.container.Clinics;
import com.septgroup.accountservice.entity.ClinicPOJO;
import com.septgroup.accountservice.exception.AlreadyExistException;
import com.septgroup.accountservice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClinicService {
    Clinics getAllClinics();

    Clinic getClinic(String clinicName) throws NotFoundException;

    void addClinic(Clinic newClinic) throws AlreadyExistException;

    void updateClinic(Clinic newClinic) throws NotFoundException;

    void deleteClinic(String clinicName) throws NotFoundException;

    ClinicPOJO returnIfFoundElseThrow(String clinicName) throws NotFoundException;
}
