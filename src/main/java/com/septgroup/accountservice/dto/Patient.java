package com.septgroup.accountservice.dto;

import com.septgroup.accountservice.shared.Sex;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Patient extends User {
    private Date DOB;
    private List<Prescription> prescriptions;
    private HealthStatus healthStatus;

    public Patient(String id, String email, String firstName, String lastName, Sex sex, String mobileNumber, Date DOB,
                   List<Prescription> prescriptions, HealthStatus healthStatus) {
        super(id, email, firstName, lastName, sex, mobileNumber);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return DOB.equals(patient.DOB) && prescriptions.equals(patient.prescriptions) && healthStatus == patient.healthStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), DOB, prescriptions, healthStatus);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "prescription_id='" + getId() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", sex='" + getSex() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", DOB=" + DOB + '\'' +
                ", prescriptions=" + prescriptions + '\'' +
                ", healthStatus=" + healthStatus + '\'' +
                "}";
    }
}
