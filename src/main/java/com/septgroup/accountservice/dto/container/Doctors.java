package com.septgroup.accountservice.dto.container;

import com.septgroup.accountservice.dto.Doctor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Doctors {
    private List<Doctor> doctors;

    public Doctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Doctor> getDoctors() {
        if (doctors == null) {
            doctors = new ArrayList<>();
        }

        return Collections.unmodifiableList(doctors);
    }
}
