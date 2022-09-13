package com.septgroup.accountservice.model.singular;

//Doctor
//		- CRUD: Email, Password, First name, Last name, Gender, Mobile Number, Clinics working at, Documents, Availability
//
//		Patient
//		- CRUD: Email, Password, First name, Last name, DOB, Gender, Mobile Number, Current prescriptions, Health status (fever, pain, etc)
public abstract class User {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String mobileNumber;

    public User(String id, String email, String firstName, String lastName, String gender, String mobileNumber) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
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

    public String getGender() {
        return gender;
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
