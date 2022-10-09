package com.septgroup.accountservice.entity;

import javax.persistence.*;

@Entity(name = "Clinic")
@Table(name = "Clinic")
public class ClinicPOJO {
    @Id
    @Column(name = "clinic_name")
    private String clinicName;
    @Column(name = "location", nullable = false, unique = true)
    private String location;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public ClinicPOJO(String clinicName, String location, String phoneNumber) {
        this.clinicName = clinicName;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public ClinicPOJO() {

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
