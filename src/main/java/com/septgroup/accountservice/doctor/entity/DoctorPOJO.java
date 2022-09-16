package com.septgroup.accountservice.doctor.entity;

import com.septgroup.accountservice.shared.entity.UserPOJO;

import javax.persistence.*;

@Entity
@Table(name = "Doctor")
public class DoctorPOJO extends UserPOJO {
    @Id
    @GeneratedValue
    @Column(name = "clinic_id")
    private Long clinicID;
}
