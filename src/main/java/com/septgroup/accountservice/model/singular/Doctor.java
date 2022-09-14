package com.septgroup.accountservice.model.singular;

import java.util.List;
import java.util.Objects;

public class Doctor extends User {
    private Availability availability;
    private List<Clinic> clinicsWorkingAt;

    public Doctor(String id, String email, String firstName, String lastName, String gender, String mobileNumber, Availability availability, List<Clinic> clinicsWorkingAt) {
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

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public void setClinicsWorkingAt(List<Clinic> clinicsWorkingAt) {
        this.clinicsWorkingAt = clinicsWorkingAt;
    }
}
