package com.septgroup.accountservice.model.singular;

import java.util.Date;
import java.util.List;

public class Patient extends User {
    private Date DOB;
    private List<Prescription> prescriptions;
    private HealthStatus healthStatus;

    public Patient(String id, String email, String firstName, String lastName, String gender, String mobileNumber, Date DOB, List<Prescription> prescriptions, HealthStatus healthStatus) {
        super(id, email, firstName, lastName, gender, mobileNumber);
        this.DOB = DOB;
        this.prescriptions = prescriptions;
        this.healthStatus = healthStatus;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }
}
