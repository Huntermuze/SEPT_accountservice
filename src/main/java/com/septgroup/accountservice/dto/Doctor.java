package com.septgroup.accountservice.dto;

import java.util.Objects;

public class Doctor extends User {
    private String clinicName;

    public Doctor(String id, String email, String firstName, String lastName, String mobileNumber, String clinicName) {
        super(id, email, firstName, lastName, mobileNumber);
        this.clinicName = clinicName;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return clinicName.equals(doctor.clinicName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), clinicName);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + getId() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", clinicName=" + clinicName + '\'' +
                "}";
    }
}
