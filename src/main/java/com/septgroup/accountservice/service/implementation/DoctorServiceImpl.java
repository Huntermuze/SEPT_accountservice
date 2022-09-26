package com.septgroup.accountservice.service.implementation;

import com.septgroup.accountservice.dto.Doctor;
import com.septgroup.accountservice.dto.container.Doctors;
import com.septgroup.accountservice.entity.DoctorPOJO;
import com.septgroup.accountservice.exception.AlreadyExistException;
import com.septgroup.accountservice.exception.InvalidIdException;
import com.septgroup.accountservice.exception.NotFoundException;
import com.septgroup.accountservice.repository.DoctorRepository;
import com.septgroup.accountservice.service.api.ClinicService;
import com.septgroup.accountservice.service.api.DoctorService;
import com.septgroup.accountservice.service.implementation.business.DoctorMergeService;
import com.septgroup.accountservice.util.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {
    // TODO add in LRU cache support for faster retrieval.
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DoctorMergeService doctorMergeService;
    @Autowired
    ClinicService clinicService;

    @Override
    public Doctors getDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        doctorRepository.findAll().stream().map(user -> doctorMergeService.doctorEntityToDTO(user)).forEach(doctors::add);
        return new Doctors(doctors);
    }

    @Override
    public Doctor getDoctor(String doctorID) throws InvalidIdException, NotFoundException {
        UUID uuid = VerificationUtil.ifValidGetUUID(doctorID);
        return doctorMergeService.doctorEntityToDTO(returnIfFoundElseThrow(uuid));
    }

    @Override
    public Doctor getDoctor(Doctor doc) throws InvalidIdException, NotFoundException {
        return getDoctor(doc.getId());
    }

    @Override
    public void addDoctor(Doctor doc) throws InvalidIdException, AlreadyExistException, NotFoundException {
        // Ignore the return value.
        clinicService.returnIfFoundElseThrow(doc.getClinicWorkingAt());
        try {
            if (getDoctor(doc).getId().equals(doc.getId())) {
                throw new AlreadyExistException(String.format("A doctor with this id (%s) already exists!", doc.getId()));
            }
        } catch (NotFoundException | NoSuchElementException ignored) {
            doctorRepository.save(doctorMergeService.doctorDTOToEntity(doc, doc.getClinicWorkingAt()));
        }
    }

    @Override
    public void updateDoctor(Doctor newDoctor) throws InvalidIdException, NotFoundException {
        UUID uuid = VerificationUtil.ifValidGetUUID(newDoctor.getId());
        DoctorPOJO docToUpdate = returnIfFoundElseThrow(uuid);
        docToUpdate.setEmail(newDoctor.getEmail());
        docToUpdate.setFirstName(newDoctor.getFirstName());
        docToUpdate.setLastName(newDoctor.getLastName());
        docToUpdate.setMobileNumber(newDoctor.getMobileNumber());
        doctorRepository.save(docToUpdate);
    }

    @Override
    public void removeDoctor(String doctorID) throws InvalidIdException, NotFoundException {
        UUID uuid = VerificationUtil.ifValidGetUUID(doctorID);
        doctorRepository.delete(returnIfFoundElseThrow(uuid));
    }

    public DoctorPOJO returnIfFoundElseThrow(UUID doctorID) throws NotFoundException {
        var result = doctorRepository.findById(doctorID);
        if (result.isEmpty()) {
            throw new NotFoundException(String.format("The doctor (with id %s) does not exist!", doctorID));
        }
        return result.get();
    }
}
