package com.septgroup.accountservice.shared.dto;

import com.septgroup.accountservice.shared.Sex;

import java.util.Objects;

public abstract class User {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Sex sex;
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

    public String getId() {
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

    public void setId(String id) {
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
}
