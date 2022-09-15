package com.septgroup.accountservice.model.singular;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity(name = "Patient")
@Table(name = "Patient")
// TODO sort out what im doing with the list columns (prescriptions).
public class Patient extends User {
    @Column(
            name = "dob",
            nullable = false
    )
    private Date DOB;

    private List<Prescription> prescriptions;
    @Column(
            name = "health_status",
            nullable = false
    )
    private User.HealthStatus healthStatus;

    public Patient(String email, String firstName, String lastName, User.Sex sex, String mobileNumber, Date DOB, List<Prescription> prescriptions, HealthStatus healthStatus) {
        super(email, firstName, lastName, sex, mobileNumber);
        this.DOB = DOB;
        this.prescriptions = prescriptions;
        this.healthStatus = healthStatus;
    }

    public Patient() {
        super();
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
    public String toString() {
        return "Patient{" +
                "id='" + getId() + '\'' +
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
