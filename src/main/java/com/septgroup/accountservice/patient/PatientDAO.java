package com.septgroup.accountservice.patient;

import com.septgroup.accountservice.patient.dto.Patient;
import com.septgroup.accountservice.patient.dto.container.Patients;
import org.springframework.stereotype.Component;

import java.util.Optional;
// TODO WORK OUT HOW TO CREATE SERVICES TO MERGE DTO WITH ENTITY
//  ALSO WORK OUT WHERE TO MAKE DATABASE CALLS AND HOW TO GET THEM HERE.

@Component("PatientDAO")
public class PatientDAO {
    private static final Patients patientsList = new Patients();

    public Patients getPatients() {
        return patientsList;
    }

    public Optional<Patient> getPatient(String id) {
        return patientsList.getPatients().stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public Optional<Patient> getPatient(Patient patient) {
        return patientsList.getPatients().stream().filter(d -> d.getId().equals(patient.getId())).findFirst();
    }

    public void addPatient(Patient patient) {
        // Also add to database.
        patientsList.getPatients().add(patient);
    }

    public void removePatient(Patient patient) {
        patientsList.getPatients().remove(patient);
    }

    public void removePatient(String id) {
        var found = patientsList.getPatients().stream().filter(d -> d.getId().equals(id)).findFirst();
        found.ifPresent(patient -> patientsList.getPatients().remove(patient));
    }
}
