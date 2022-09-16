package com.septgroup.accountservice.patient.dto.container;

import com.septgroup.accountservice.patient.dto.Patient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patients {
    private List<Patient> patients;

    public List<Patient> getPatients() {
        if (patients == null) {
            patients = new ArrayList<>();
        }

        return Collections.unmodifiableList(patients);
    }
}
