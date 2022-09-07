package com.septgroup.accountservice.model;

import java.util.List;

public class Doctor extends User{
    private final Availability availability;
    private final List<Clinic> clinicsWorkingAt;

    public Doctor(int id, String email, String firstName, String lastName, String gender, String mobileNumber, Availability availability, List<Clinic> clinicsWorkingAt) {
        super(id, email, firstName, lastName, gender, mobileNumber);
        this.availability = availability;
        this.clinicsWorkingAt = clinicsWorkingAt;
    }

    public Availability getAvailability() {
        return availability;
    }

    public List<Clinic> getClinicsWorkingAt() {
        return clinicsWorkingAt;
    }


}
