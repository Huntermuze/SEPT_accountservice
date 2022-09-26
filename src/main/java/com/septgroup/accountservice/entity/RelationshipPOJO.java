package com.septgroup.accountservice.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "Relationship")
@Table(name = "Relationship")
public class RelationshipPOJO {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "patient_id")
    private UUID patientID;
    @Column(name = "doctor_id")
    private UUID doctorID;

    public RelationshipPOJO(UUID patientID, UUID doctorID) {
        this.patientID = patientID;
        this.doctorID = doctorID;
    }

    public RelationshipPOJO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getPatientID() {
        return patientID;
    }

    public void setPatientID(UUID patientID) {
        this.patientID = patientID;
    }

    public UUID getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(UUID doctorID) {
        this.doctorID = doctorID;
    }
}
