package com.septgroup.accountservice.patient;

import com.septgroup.accountservice.patient.dto.Patient;
import com.septgroup.accountservice.patient.dto.container.Patients;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO ONLY NEED ONE GENERIC INTERFACE FOR THIS (INSTEAD OF PATIENTSERVICE & DOCTORSERVICE). Make impls share the same
//  interface, and the controllers use the abstraction (this generic interface).
@Service
public interface PatientService {

    Patients getPatients();

    Optional<Patient> getPatient(String id);

    Optional<Patient> getPatient(Patient patient);

    void addPatient(Patient patient);

    void removePatient(Patient patient);

    void removePatient(String id);
}
