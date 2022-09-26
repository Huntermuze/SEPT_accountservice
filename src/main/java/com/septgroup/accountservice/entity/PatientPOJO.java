package com.septgroup.accountservice.entity;

import com.septgroup.accountservice.dto.HealthStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity(name = "Patient")
@Table(name = "Patient")
public class PatientPOJO extends UserPOJO {
    @Column(name = "dob", nullable = false)
    private Date DOB;
    @Column(name = "health_status", nullable = false)
    private HealthStatus healthStatus;

    public PatientPOJO(UUID id, String email, String firstName, String lastName, String mobileNumber, Date DOB, HealthStatus healthStatus) {
        super(id, email, firstName, lastName, mobileNumber);
        this.DOB = DOB;
        this.healthStatus = healthStatus;
    }

    public PatientPOJO() {

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
}
