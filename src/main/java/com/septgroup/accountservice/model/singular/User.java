package com.septgroup.accountservice.model.singular;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

//Doctor
//		- CRUD: Email, Password, First name, Last name, sex, Mobile Number, Clinics working at, Documents, Availability
//
//		Patient
//		- CRUD: Email, Password, First name, Last name, DOB, sex, Mobile Number, Current prescriptions, Health status (fever, pain, etc)

@MappedSuperclass
public abstract class User {
    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @Column(
            name = "id",
            updatable = false
    )
    @GeneratedValue()
    private UUID id;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name = "sex",
            nullable = false
    )
    private Sex sex;
    @Column(
            name = "mobile_number",
            nullable = false,
            unique = true
    )
    private String mobileNumber;

    public User(String email, String firstName, String lastName, Sex sex, String mobileNumber) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.mobileNumber = mobileNumber;
    }

    public User() {

    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && email.equals(user.email) && firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) && sex.equals(user.sex) && mobileNumber.equals(user.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, sex, mobileNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    public enum HealthStatus {
        EXCELLENT,
        GOOD,
        MODERATE,
        POOR,
        TERRIBLE,
        EMERGENCY
    }

    public enum Sex {
        MALE,
        FEMALE
    }
}
