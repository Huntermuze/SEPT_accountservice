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
    private static final Doctors doctorsList = new Doctors();
    private static final Patients patientsList = new Patients();

    public Doctors getDoctors() {
        return doctorsList;
    }

    public Patients getPatients() {
        return patientsList;
    }

    public Optional<Doctor> getDoctor(String uuid) {
        return doctorsList.getDoctors().stream().filter(d -> d.getId().equals(uuid)).findFirst();
    }

    public Optional<Doctor> getDoctor(Doctor doc) {
        return doctorsList.getDoctors().stream().filter(d -> d.getId().equals(doc.getId())).findFirst();
    }

    public Optional<Patient> getPatient(String uuid) {
        return patientsList.getPatients().stream().filter(d -> d.getId().equals(uuid)).findFirst();
    }

    public Optional<Patient> getPatient(Patient patient) {
        return patientsList.getPatients().stream().filter(d -> d.getId().equals(patient.getId())).findFirst();
    }

    public void addDoctor(Doctor doc) {
        // Also add to database.
        doctorsList.getDoctors().add(doc);
    }

    public void addPatient(Patient patient) {
        // Also add to database.
        patientsList.getPatients().add(patient);
    }

    public void removeDoctor(Doctor doc) {
        doctorsList.getDoctors().remove(doc);
    }

    public void removeDoctor(String uuid) {
        var found = patientsList.getPatients().stream().filter(d -> d.getId().equals(uuid)).findFirst();
        found.ifPresent(doctor -> patientsList.getPatients().remove(doctor));
    }

    public void removePatient(Patient patient) {
        patientsList.getPatients().remove(patient);
    }

    public void removePatient(String uuid) {
        var found = doctorsList.getDoctors().stream().filter(d -> d.getId().equals(uuid)).findFirst();
        found.ifPresent(patient -> doctorsList.getDoctors().remove(patient));
    }
}
