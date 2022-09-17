package com.septgroup.accountservice.patient;

import com.septgroup.accountservice.patient.entity.PatientPOJO;
import com.septgroup.accountservice.shared.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends UserRepository<PatientPOJO, UUID> {
}
