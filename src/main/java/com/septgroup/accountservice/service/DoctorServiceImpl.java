package com.septgroup.accountservice.service;

import com.septgroup.accountservice.dto.Doctor;
import com.septgroup.accountservice.dto.container.Doctors;
import com.septgroup.accountservice.entity.DoctorPOJO;
import com.septgroup.accountservice.exception.InvalidIdException;
import com.septgroup.accountservice.exception.NotFoundException;
import com.septgroup.accountservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {
    // TODO add in LRU cache support for faster retrieval.
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    MergeService mergeService;

    public Doctors getDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        doctorRepository.findAll().stream().map(user -> mergeService.doctorEntityToDTO(user)).forEach(doc -> doc.ifPresent(doctors::add));
        return new Doctors(doctors);
    }

    // TODO Finish off all these methods, and do the same for the PatientRepository. Then also change to the layer structure
    //  since this project hsa grown in complexity. Then test these finally.
    public Optional<Doctor> getDoctor(String id) throws NotFoundException {
        // TODO migrate all exceptions from the controller to the service layer like this.
        //  DO SAME FOR PatientServiceImpl.
        Optional<DoctorPOJO> doctor;
        try {
            doctor = doctorRepository.findById(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            throw new NotFoundException(e.getMessage());
        }
        if (doctor.isEmpty()) {
            return Optional.empty();
        }
        return mergeService.doctorEntityToDTO(doctor.get());
    }

    public Optional<Doctor> getDoctor(Doctor doc) throws NotFoundException {
        Optional<DoctorPOJO> doctor;
        try {
            doctor = doctorRepository.findById(UUID.fromString(doc.getId()));
        } catch (IllegalArgumentException e) {
            throw new NotFoundException(e.getMessage());
        }
        if (doctor.isEmpty()) {
            return Optional.empty();
        }
        return mergeService.doctorEntityToDTO(doctor.get());
    }

    public void addDoctor(Doctor doc) throws InvalidIdException {
        try {
            UUID.fromString(doc.getId());
            doctorRepository.save(mergeService.doctorDTOToEntity(doc));
        } catch (IllegalArgumentException e) {
            throw new InvalidIdException(e.getMessage());
        }
    }

    public void removeDoctor(Doctor doc) throws NotFoundException {
        UUID uuid;
        try {
            uuid = UUID.fromString(doc.getId());
        } catch (IllegalArgumentException e) {
            throw new NotFoundException(e.getMessage());
        }
        doctorRepository.deleteById(uuid);
    }

    public void removeDoctor(String id) throws NotFoundException {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new NotFoundException(e.getMessage());
        }
        doctorRepository.deleteById(uuid);
    }
}
