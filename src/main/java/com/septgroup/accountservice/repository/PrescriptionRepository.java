package com.septgroup.accountservice.repository;

import com.septgroup.accountservice.entity.PrescriptionPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<PrescriptionPOJO, Long> {
    @Query(value = "SELECT * FROM Prescription p WHERE p.patient_id = ?1", nativeQuery = true)
    List<PrescriptionPOJO> findAllPrescriptionForPatient(String patientID);

    @Query(value = "SELECT * FROM Prescription p WHERE p.prescriber_id = ?1", nativeQuery = true)
    List<PrescriptionPOJO> findAllPrescribedByDoctor(String doctorID);

    @Query(value = "SELECT * FROM Prescription p WHERE p.drug_name=?1 AND p.pharmaceutical_company=?2 AND p.quantity=?3 AND p.patient_id=?4 AND p.prescriber_id=?5", nativeQuery = true)
    Optional<PrescriptionPOJO> findByPrescriptionDTO(String drugName, String pharmaCompany, double quantity, String patientID, String doctorID);
}
