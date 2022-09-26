package com.septgroup.accountservice.dto;

public class Relationship {
    private String patientID;
    private String doctorID;

    public Relationship(String patientID, String doctorID) {
        this.patientID = patientID;
        this.doctorID = doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }
}
