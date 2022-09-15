package com.septgroup.accountservice.model.singular;

public record Prescription(String drugName, double quantity, String pharmaceuticalCompany, Doctor prescriber) {
}
