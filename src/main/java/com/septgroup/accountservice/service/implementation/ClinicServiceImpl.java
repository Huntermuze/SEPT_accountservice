package com.septgroup.accountservice.service.implementation;

import com.septgroup.accountservice.dto.Clinic;
import com.septgroup.accountservice.dto.container.Clinics;
import com.septgroup.accountservice.entity.ClinicPOJO;
import com.septgroup.accountservice.exception.AlreadyExistException;
import com.septgroup.accountservice.exception.NotFoundException;
import com.septgroup.accountservice.repository.ClinicRepository;
import com.septgroup.accountservice.service.api.ClinicService;
import com.septgroup.accountservice.service.implementation.business.ClinicMergeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ClinicServiceImpl implements ClinicService {
    @Autowired
    ClinicRepository clinicRepository;
    @Autowired
    ClinicMergeService clinicMergeService;

    @Override
    public Clinics getAllClinics() {
        return new Clinics(clinicRepository.findAll().stream().map(c -> clinicMergeService.clinicEntityToDTO(c)).collect(Collectors.toList()));
    }

    @Override
    public Clinic getClinic(String clinicName) throws NotFoundException {
        return clinicMergeService.clinicEntityToDTO(returnIfFoundElseThrow(clinicName));
    }

    @Override
    public void addClinic(Clinic newClinic) throws AlreadyExistException {
        var result = clinicRepository.findById(newClinic.clinicName());
        if (result.isPresent()) {
            throw new AlreadyExistException(String.format("%s already exists!", newClinic.clinicName()));
        }
        clinicRepository.save(clinicMergeService.clinicDTOToEntity(newClinic));
    }

    @Override
    public void updateClinic(Clinic newClinic) throws NotFoundException {
        ClinicPOJO clinicToUpdate = returnIfFoundElseThrow(newClinic.clinicName());
        clinicToUpdate.setPhoneNumber(newClinic.phoneNumber());
        clinicToUpdate.setLocation(newClinic.location());
        clinicRepository.save(clinicToUpdate);
    }

    @Override
    public void deleteClinic(String clinicName) throws NotFoundException {
        clinicRepository.delete(returnIfFoundElseThrow(clinicName));
    }

    @Override
    public ClinicPOJO returnIfFoundElseThrow(String clinicName) throws NotFoundException {
        var clinicFound = clinicRepository.findById(clinicName);
        if (clinicFound.isEmpty()) {
            throw new NotFoundException(String.format("Clinic \"%s\" does not exist! Please create it first.", clinicName));
        }
        return clinicFound.get();
    }
}
