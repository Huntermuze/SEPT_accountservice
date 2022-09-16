package com.septgroup.accountservice.patient.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Prescription")
public class PrescriptionPOJO {
    // TODO ignore this. Just to satisfy JPA Hibernate.
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "drug_name", nullable = false)
    private String drugName;
    @Column(name = "quantity", nullable = false)
    private double quantity;
    @Column(name = "pharmaceutical_company", nullable = false)
    private String pharmaceuticalCompany;
    @Column(name = "prescriber_id", nullable = false)
    private String prescriberId;
    @Column(name = "patient_id", nullable = false)
    private String patientId;
}
