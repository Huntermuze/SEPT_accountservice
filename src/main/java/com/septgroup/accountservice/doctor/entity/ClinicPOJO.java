package com.septgroup.accountservice.doctor.entity;

import javax.persistence.*;

@Entity
@Table(name = "Clinic")
public class ClinicPOJO {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "clinicID", sequenceName = "clinicID")
    @Column(name = "clinic_id")
    private Long clinicID;
    @Column(name = "clinic_name", nullable = false)
    private String clinicName;
    @Column(name = "location", nullable = false, unique = true)
    private String location;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}
