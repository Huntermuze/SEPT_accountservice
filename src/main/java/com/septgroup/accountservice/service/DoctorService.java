package com.septgroup.accountservice.service;

import com.septgroup.accountservice.dto.Doctor;
import com.septgroup.accountservice.dto.container.Doctors;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO ONLY NEED ONE GENERIC INTERFACE FOR THIS (INSTEAD OF PATIENTSERVICE & DOCTORSERVICE). Make impls share the same
//  interface, and the controllers use the abstraction (this generic interface).
@Service
public interface DoctorService {
    Doctors getDoctors();

    Optional<Doctor> getDoctor(String id);

    Optional<Doctor> getDoctor(Doctor doc);

    void addDoctor(Doctor doc);

    void removeDoctor(Doctor doc);

    void removeDoctor(String id);
}
