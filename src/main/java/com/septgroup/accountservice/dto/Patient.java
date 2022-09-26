package com.septgroup.accountservice.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Patient extends User {
    private Date DOB;
    private HealthStatus healthStatus;

    public Patient(String id, String email, String firstName, String lastName, String mobileNumber, Date DOB,
                   List<Prescription> prescriptions, HealthStatus healthStatus) {
        super(id, email, firstName, lastName, mobileNumber);
        this.DOB = DOB;
        this.healthStatus = healthStatus;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return DOB.equals(patient.DOB) && healthStatus == patient.healthStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), DOB, healthStatus);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "prescription_id='" + getId() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", DOB=" + DOB + '\'' +
                ", healthStatus=" + healthStatus + '\'' +
                "}";
    }
}
