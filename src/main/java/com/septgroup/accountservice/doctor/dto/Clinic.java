package com.septgroup.accountservice.doctor.dto;

import java.util.Collections;
import java.util.List;

public record Clinic(String clinicName, List<Doctor> doctorList) {
}
