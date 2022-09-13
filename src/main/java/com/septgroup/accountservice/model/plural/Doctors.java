package com.septgroup.accountservice.model.plural;

import com.septgroup.accountservice.model.singular.Doctor;

import java.util.ArrayList;
import java.util.List;

public class Doctors {
    private List<Doctor> doctors;

    public List<Doctor> getDoctors() {
        if (doctors == null) {
            doctors = new ArrayList<>();
        }

        return doctors;
    }
}
