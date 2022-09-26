package com.septgroup.accountservice.dto.container;

import com.septgroup.accountservice.dto.Clinic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clinics {
    private List<Clinic> clinics;

    public Clinics(List<Clinic> clinics) {
        this.clinics = clinics;
    }

    public List<Clinic> getClinics() {
        if (clinics == null) {
            clinics = new ArrayList<>();
        }

        return Collections.unmodifiableList(clinics);
    }
}
