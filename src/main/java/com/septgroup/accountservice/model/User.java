package com.septgroup.accountservice.model;

//Doctor
//		- CRUD: Email, Password, First name, Last name, Gender, Mobile Number, Clinics working at, Documents, Availability
//
//		Patient
//		- CRUD: Email, Password, First name, Last name, DOB, Gender, Mobile Number, Current prescriptions, Health status (fever, pain, etc)
public abstract class User {
    private final int id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String mobileNumber;

    public User(int id, String email, String firstName, String lastName, String gender, String mobileNumber) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
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

    public String getGender() {
        return gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
