package com.septgroup.accountservice.patient.dto;

public record Prescription(long prescription_id, String drugName, double quantity, String pharmaceuticalCompany) {
}
