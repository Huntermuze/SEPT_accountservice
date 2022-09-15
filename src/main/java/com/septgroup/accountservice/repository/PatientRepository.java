package com.septgroup.accountservice.repository;

import com.septgroup.accountservice.model.singular.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {
}
