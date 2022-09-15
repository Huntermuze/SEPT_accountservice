package com.septgroup.accountservice.model.singular;

import javax.persistence.Entity;
import java.util.List;

// TODO figure out how to create table of custom classes (for doctor - appointment) and how to map it properly.
@Entity(name = "Doctor")
public class Doctor extends User {
    private Availability availability;
    private List<Clinic> clinicsWorkingAt;

    public Doctor() {
    }

    public Doctor(String email, String firstName, String lastName, User.Sex sex, String mobileNumber, Availability availability, List<Clinic> clinicsWorkingAt) {
        super(email, firstName, lastName, sex, mobileNumber);
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

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + getId() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", sex='" + getSex() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", availability=" + availability + '\'' +
                ", clinicsWorkingAt=" + clinicsWorkingAt + '\'' +
                "}";
    }
}
