package com.septgroup.accountservice.repository;

import com.septgroup.accountservice.entity.PrescriptionPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<PrescriptionPOJO, Long> {
    @Query(value = "SELECT * FROM Prescription p WHERE p.patient_id = ?1", nativeQuery = true)
    List<PrescriptionPOJO> findAllPrescriptionForPatient(String patientID);
}
