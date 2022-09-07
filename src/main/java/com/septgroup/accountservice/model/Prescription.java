package com.septgroup.accountservice.model;

public record Prescription(String drugName, double quantity, String pharmaceuticalCompany, Doctor prescriber) {
}
