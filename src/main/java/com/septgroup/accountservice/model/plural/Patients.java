package com.septgroup.accountservice.model.plural;

import com.septgroup.accountservice.model.singular.Patient;

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
