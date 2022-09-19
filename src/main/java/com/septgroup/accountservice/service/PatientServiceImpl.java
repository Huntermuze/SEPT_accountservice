package com.septgroup.accountservice.service;

import com.septgroup.accountservice.exception.InvalidIdException;
import com.septgroup.accountservice.exception.NotFoundException;
import com.septgroup.accountservice.dto.Patient;
import com.septgroup.accountservice.dto.container.Patients;
import com.septgroup.accountservice.entity.PatientPOJO;
import com.septgroup.accountservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {
    // TODO add in LRU cache support for faster retrieval.
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    MergeService mergeService;

    public Patients getPatients() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().stream().map(user -> mergeService.patientEntityToDTO(user)).forEach(patient -> patient.ifPresent(patients::add));
        return new Patients(patients);
    }

    public Optional<Patient> getPatient(String id) throws NotFoundException {
        Optional<PatientPOJO> patient;
        try {
            patient = patientRepository.findById(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            throw new NotFoundException(e.getMessage());
        }
        if (patient.isEmpty()) {
            return Optional.empty();
        }
        return mergeService.patientEntityToDTO(patient.get());
    }

    public Optional<Patient> getPatient(Patient patient) throws NotFoundException {
        Optional<PatientPOJO> foundPatient;
        try {
            foundPatient = patientRepository.findById(UUID.fromString(patient.getId()));
        } catch (IllegalArgumentException e) {
            throw new NotFoundException(e.getMessage());
        }
        if (foundPatient.isEmpty()) {
            return Optional.empty();
        }
        return mergeService.patientEntityToDTO(foundPatient.get());
    }

    public void addPatient(Patient patient) throws InvalidIdException {
        try {
            UUID.fromString(patient.getId());
            patientRepository.save(mergeService.patientDTOToEntity(patient));
        } catch (IllegalArgumentException e) {
            throw new InvalidIdException(e.getMessage());
        }
    }

    public void removePatient(Patient patient) throws NotFoundException {
        // TODO need to use regex here, as apprently fromString is limited.
        //  https://stackoverflow.com/questions/20041051/how-to-judge-a-string-is-uuid-type
        UUID uuid;
        try {
            uuid = UUID.fromString(patient.getId());
        } catch (IllegalArgumentException e) {
            throw new NotFoundException(e.getMessage());
        }
        patientRepository.deleteById(uuid);
    }

    public void removePatient(String id) throws NotFoundException {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException(e.getMessage());
        }
        patientRepository.deleteById(uuid);
    }
}
