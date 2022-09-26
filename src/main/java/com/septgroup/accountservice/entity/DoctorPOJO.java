package com.septgroup.accountservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "Doctor")
@Table(name = "Doctor")
public class DoctorPOJO extends UserPOJO {
    @Column(name = "clinic_name", nullable = false)
    private String clinicName;

    public DoctorPOJO(UUID id, String email, String firstName, String lastName, String mobileNumber, String clinicName) {
        super(id, email, firstName, lastName, mobileNumber);
        this.clinicName = clinicName;
    }

    public DoctorPOJO() {

    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
}
