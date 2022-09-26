package com.septgroup.accountservice.service.api;

import com.septgroup.accountservice.dto.Doctor;
import com.septgroup.accountservice.dto.container.Doctors;
import com.septgroup.accountservice.exception.AlreadyExistException;
import com.septgroup.accountservice.exception.InvalidIdException;
import com.septgroup.accountservice.exception.NotFoundException;
import org.springframework.stereotype.Service;

// TODO ONLY NEED ONE GENERIC INTERFACE FOR THIS (INSTEAD OF PATIENTSERVICE & DOCTORSERVICE). Make impls share the same
//  interface, and the controllers use the abstraction (this generic interface).
@Service
public interface DoctorService {
    Doctors getDoctors();

    Doctor getDoctor(Doctor doc);

    Doctor getDoctor(String doctorID);

    void addDoctor(Doctor doc) throws InvalidIdException, AlreadyExistException, NotFoundException;

    void updateDoctor(Doctor newDoctor) throws InvalidIdException, NotFoundException;

    void removeDoctor(String doctorID);
}
