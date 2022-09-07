package com.septgroup.accountservice.model;

import java.util.Collections;
import java.util.List;

public class Clinic {
    private final String clinicName;
    private final List<Doctor> doctorsList;

    public Clinic(String clinicName, List<Doctor> doctorsList) {
        this.clinicName = clinicName;
        this.doctorsList = doctorsList;
    }

    public String getClinicName() {
        return clinicName;
    }

    public List<Doctor> getDoctorsList() {
        return Collections.unmodifiableList(doctorsList);
    }
}
