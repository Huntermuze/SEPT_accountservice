package com.septgroup.accountservice.doctor.dto.container;

import com.septgroup.accountservice.doctor.dto.Doctor;
import com.septgroup.accountservice.shared.dto.User;

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
