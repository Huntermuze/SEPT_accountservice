package com.septgroup.accountservice.entity;

import javax.persistence.*;

@Entity(name = "Clinic")
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

    public ClinicPOJO(Long clinicID, String clinicName, String location, String phoneNumber) {
        this.clinicID = clinicID;
        this.clinicName = clinicName;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public ClinicPOJO() {

    }

    public Long getClinicID() {
        return clinicID;
    }

    public void setClinicID(Long clinicID) {
        this.clinicID = clinicID;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
