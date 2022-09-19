package com.septgroup.accountservice.repository;

import com.septgroup.accountservice.entity.PatientPOJO;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends UserRepository<PatientPOJO, UUID> {
}
