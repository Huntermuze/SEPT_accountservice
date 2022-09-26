package com.septgroup.accountservice.service.api;

import com.septgroup.accountservice.dto.Patient;
import com.septgroup.accountservice.dto.container.Patients;
import com.septgroup.accountservice.exception.InvalidIdException;
import com.septgroup.accountservice.exception.NotFoundException;
import org.springframework.stereotype.Service;

// TODO ONLY NEED ONE GENERIC INTERFACE FOR THIS (INSTEAD OF PATIENTSERVICE & DOCTORSERVICE). Make impls share the same
//  interface, and the controllers use the abstraction (this generic interface).
@Service
public interface PatientService {

    Patients getPatients();

    Patient getPatient(Patient patient);

    Patient getPatient(String patientID);

    void addPatient(Patient patient);

    void updatePatient(Patient newPatient) throws InvalidIdException, NotFoundException;

    void removePatient(String patientID);
}
