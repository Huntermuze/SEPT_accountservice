package com.septgroup.accountservice.entity;

import com.septgroup.accountservice.dto.HealthStatus;
import com.septgroup.accountservice.shared.Sex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity(name = "Patient")
@Table(name = "Patient")
public class PatientPOJO extends UserPOJO {
    @Column(name = "dob", nullable = false)
    private Date dob;
    @Column(name = "health_status", nullable = false)
    private HealthStatus healthStatus;

    public PatientPOJO(UUID id, String email, String firstName, String lastName, Sex sex, String mobileNumber, Date dob, HealthStatus healthStatus) {
        super(id, email, firstName, lastName, sex, mobileNumber);
        this.dob = dob;
        this.healthStatus = healthStatus;
    }

    public PatientPOJO() {

    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date DOB) {
        this.dob = DOB;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }
}
