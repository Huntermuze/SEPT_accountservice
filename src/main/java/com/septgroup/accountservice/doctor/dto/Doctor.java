package com.septgroup.accountservice.doctor.dto;

import com.septgroup.accountservice.shared.Sex;
import com.septgroup.accountservice.shared.dto.User;

import java.util.Objects;

public class Doctor extends User {
    private Clinic clinicWorkingAt;

    public Doctor(String id, String email, String firstName, String lastName, Sex sex, String mobileNumber, Clinic clinicWorkingAt) {
        super(id, email, firstName, lastName, sex, mobileNumber);
        this.clinicWorkingAt = clinicWorkingAt;
    }

    public Clinic getClinicWorkingAt() {
        return clinicWorkingAt;
    }

    public void setClinicWorkingAt(Clinic clinicWorkingAt) {
        this.clinicWorkingAt = clinicWorkingAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return clinicWorkingAt.equals(doctor.clinicWorkingAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clinicWorkingAt);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "prescription_id='" + getId() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", sex='" + getSex() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", clinicWorkingAt=" + clinicWorkingAt + '\'' +
                "}";
    }
}
