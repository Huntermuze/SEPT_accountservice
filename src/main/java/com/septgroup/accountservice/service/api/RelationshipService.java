package com.septgroup.accountservice.service.api;

import com.septgroup.accountservice.dto.Doctor;
import com.septgroup.accountservice.dto.Patient;
import com.septgroup.accountservice.dto.Relationship;
import com.septgroup.accountservice.exception.InvalidIdException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RelationshipService {
    void createRelationship(Relationship relationship) throws InvalidIdException;

    void deleteRelationship(Relationship relationship);

    List<Patient> getAllPatients(String doctorID);

    List<Doctor> getAllDoctors(String patientID);
}
