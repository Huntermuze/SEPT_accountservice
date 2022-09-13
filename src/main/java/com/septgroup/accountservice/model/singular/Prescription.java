package com.septgroup.accountservice.model.singular;

import com.septgroup.accountservice.model.singular.Doctor;

public record Prescription(String drugName, double quantity, String pharmaceuticalCompany, Doctor prescriber) {
}
