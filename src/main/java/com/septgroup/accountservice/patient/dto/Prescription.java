package com.septgroup.accountservice.patient.dto;

import java.util.UUID;

public record Prescription(UUID id, String drugName, double quantity, String pharmaceuticalCompany) {
}
