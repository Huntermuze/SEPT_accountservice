package com.septgroup.accountservice.repository;

import com.septgroup.accountservice.entity.RelationshipPOJO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RelationshipRepository extends JpaRepository<RelationshipPOJO, Long> {
    @Query(value = "SELECT * FROM Relationship r WHERE r.patient_id = ?1", nativeQuery = true)
    List<RelationshipPOJO> findPatientRelationships(String patientID);

    @Query(value = "SELECT * FROM Relationship r WHERE r.doctor_id = ?1", nativeQuery = true)
    List<RelationshipPOJO> findDoctorRelationships(String doctorID);

    @Query(value = "SELECT * FROM Relationship r WHERE r.doctor_id = ?1 AND r.patient_id = ?2", nativeQuery = true)
    Optional<RelationshipPOJO> findByPatientAndDoctorIds(String doctorID, String patientID);
}
