package com.septgroup.accountservice.patient.entity;

import com.septgroup.accountservice.patient.HealthStatus;
import com.septgroup.accountservice.shared.entity.UserPOJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Patient")
public class PatientPOJO extends UserPOJO {
    @Column(name = "dob", nullable = false)
    private Date DOB;
    @Column(name = "health_status", nullable = false)
    private HealthStatus healthStatus;
}
