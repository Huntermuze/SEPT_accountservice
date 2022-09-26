package com.septgroup.accountservice.dto;

import java.util.Objects;

public class Doctor extends User {
    private String clinicWorkingAt;

    public Doctor(String id, String email, String firstName, String lastName, String mobileNumber, String clinicWorkingAt) {
        super(id, email, firstName, lastName, mobileNumber);
        this.clinicWorkingAt = clinicWorkingAt;
    }

    public String getClinicWorkingAt() {
        return clinicWorkingAt;
    }

    public void setClinicWorkingAt(String clinicWorkingAt) {
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
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", clinicWorkingAt=" + clinicWorkingAt + '\'' +
                "}";
    }
}
