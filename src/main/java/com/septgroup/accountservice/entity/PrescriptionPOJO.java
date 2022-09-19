package com.septgroup.accountservice.entity;

import javax.persistence.*;

@Entity(name = "Prescription")
@Table(name = "Prescription")
public class PrescriptionPOJO {
    // TODO ignore this. Just to satisfy JPA Hibernate.
    @Id
    @GeneratedValue
    @Column(name = "prescription_id")
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

    public PrescriptionPOJO(Long id, String drugName, double quantity, String pharmaceuticalCompany, String prescriberId, String patientId) {
        this.id = id;
        this.drugName = drugName;
        this.quantity = quantity;
        this.pharmaceuticalCompany = pharmaceuticalCompany;
        this.prescriberId = prescriberId;
        this.patientId = patientId;
    }

    public PrescriptionPOJO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getPharmaceuticalCompany() {
        return pharmaceuticalCompany;
    }

    public void setPharmaceuticalCompany(String pharmaceuticalCompany) {
        this.pharmaceuticalCompany = pharmaceuticalCompany;
    }

    public String getPrescriberId() {
        return prescriberId;
    }

    public void setPrescriberId(String prescriberId) {
        this.prescriberId = prescriberId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
