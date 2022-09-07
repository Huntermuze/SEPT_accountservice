package com.septgroup.accountservice.model;

import java.util.Date;
import java.util.List;

public class Patient extends User {
    private final Date DOB;
    private final List<Prescription> prescriptions;
    private HealthStatus healthStatus;

    public Patient(int id, String email, String firstName, String lastName, String gender, String mobileNumber, Date DOB, List<Prescription> prescriptions, HealthStatus healthStatus) {
        super(id, email, firstName, lastName, gender, mobileNumber);
        this.DOB = DOB;
        this.prescriptions = prescriptions;
        this.healthStatus = healthStatus;
    }
}
