package com.septgroup.accountservice.shared.entity;

import com.septgroup.accountservice.shared.Sex;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class UserPOJO {
    @Id
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

    public UserPOJO(String email, String firstName, String lastName, Sex sex, String mobileNumber) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.mobileNumber = mobileNumber;
    }

    public UserPOJO() {
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
}
