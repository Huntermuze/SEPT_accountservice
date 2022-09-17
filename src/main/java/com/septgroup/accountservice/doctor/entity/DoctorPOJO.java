package com.septgroup.accountservice.doctor.entity;

import com.septgroup.accountservice.shared.Sex;
import com.septgroup.accountservice.shared.entity.UserPOJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "Doctor")
@Table(name = "Doctor")
public class DoctorPOJO extends UserPOJO {
    @Column(name = "clinic_id")
    private Long clinicID;

    public DoctorPOJO(UUID id, String email, String firstName, String lastName, Sex sex, String mobileNumber, Long clinicID) {
        super(id, email, firstName, lastName, sex, mobileNumber);
        this.clinicID = clinicID;
    }

    public DoctorPOJO() {

    }

    public Long getClinicID() {
        return clinicID;
    }

    public void setClinicID(Long clinicID) {
        this.clinicID = clinicID;
    }
}
