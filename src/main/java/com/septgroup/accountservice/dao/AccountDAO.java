package com.septgroup.accountservice.dao;

import com.septgroup.accountservice.model.plural.Doctors;
import com.septgroup.accountservice.model.plural.Patients;
import com.septgroup.accountservice.model.singular.Doctor;
import com.septgroup.accountservice.model.singular.Patient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// TODO Setup database.
@Repository
public class AccountDAO {
    // TODO LRU CACHE OR 100% DATABASE FETCHING OR 100% IN-MEMORY-CACHE SYNCHRONISED WITH DB. PICK ONE.
    private Doctors doctorsList;
    private Patients patientsList;

    public Optional<Doctor> getDoctor(String uuid) {
        return doctorsList.getDoctors().stream().filter(d -> d.getId().equals(uuid)).findFirst();
    }

    public Optional<Doctor> getDoctor(Doctor doc) {
        return doctorsList.getDoctors().stream().filter(d -> d.getId().equals(doc.getId())).findFirst();
    }

    public Optional<Doctor> getPatient(String uuid) {
        return doctorsList.getDoctors().stream().filter(d -> d.getId().equals(uuid)).findFirst();
    }

    public Optional<Doctor> getPatient(Patient patient) {
        return doctorsList.getDoctors().stream().filter(d -> d.getId().equals(patient.getId())).findFirst();
    }

    public void addDoctor(Doctor doc) {
        // Also add to database.
        doctorsList.getDoctors().add(doc);
    }

    public void removeDoctor(Doctor doc) {
        doctorsList.getDoctors().remove(doc);
    }

    public void addPatient(Patient patient) {
        // Also add to database.
        patientsList.getPatients().add(patient);
    }

    public void removePatient(Patient patient) {
        patientsList.getPatients().remove(patient);
    }
}
