package com.septgroup.accountservice.service.implementation;

import com.septgroup.accountservice.dto.Doctor;
import com.septgroup.accountservice.dto.Patient;
import com.septgroup.accountservice.dto.Relationship;
import com.septgroup.accountservice.entity.DoctorPOJO;
import com.septgroup.accountservice.entity.PatientPOJO;
import com.septgroup.accountservice.entity.RelationshipPOJO;
import com.septgroup.accountservice.exception.AlreadyExistException;
import com.septgroup.accountservice.exception.InvalidIdException;
import com.septgroup.accountservice.repository.DoctorRepository;
import com.septgroup.accountservice.repository.PatientRepository;
import com.septgroup.accountservice.repository.RelationshipRepository;
import com.septgroup.accountservice.service.api.RelationshipService;
import com.septgroup.accountservice.service.implementation.business.DoctorMergeService;
import com.septgroup.accountservice.service.implementation.business.PatientMergeService;
import com.septgroup.accountservice.service.implementation.business.RelationshipMergeService;
import com.septgroup.accountservice.util.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Autowired
    RelationshipRepository relationshipRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientMergeService patientMergeService;
    @Autowired
    DoctorMergeService doctorMergeService;
    @Autowired
    RelationshipMergeService relationshipMergeService;

    public List<Patient> getAllPatients(String doctorID) throws InvalidIdException {
        VerificationUtil.throwIfNotValid(doctorID);
        List<Patient> patients = new ArrayList<>();
        for (RelationshipPOJO r : relationshipRepository.findDoctorRelationships(doctorID)) {
            PatientPOJO pojo = patientRepository.findById(r.getPatientID()).get();
            patients.add(patientMergeService.patientEntityToDTO(pojo));
        }
        return patients;
    }

    public List<Doctor> getAllDoctors(String patientID) throws InvalidIdException {
        VerificationUtil.throwIfNotValid(patientID);
        List<Doctor> doctors = new ArrayList<>();
        for (RelationshipPOJO r : relationshipRepository.findPatientRelationships(patientID)) {
            DoctorPOJO pojo = doctorRepository.findById(r.getDoctorID()).get();
            doctors.add(doctorMergeService.doctorEntityToDTO(pojo));
        }
        return doctors;
    }

    public void createRelationship(Relationship relationship) throws InvalidIdException, AlreadyExistException {
        VerificationUtil.throwIfNotValid(relationship.getPatientID());
        VerificationUtil.throwIfNotValid(relationship.getDoctorID());
        if (relationshipRepository.findByPatientAndDoctorIds(relationship.getDoctorID(), relationship.getPatientID()).isPresent()) {
            throw new AlreadyExistException("This relationship already exists!");
        }
        relationshipRepository.save(relationshipMergeService.dtoToEntity(relationship));
    }

    public void deleteRelationship(Relationship relationship) throws InvalidIdException, AlreadyExistException {
        VerificationUtil.throwIfNotValid(relationship.getPatientID());
        VerificationUtil.throwIfNotValid(relationship.getDoctorID());
        if (relationshipRepository.findByPatientAndDoctorIds(relationship.getDoctorID(), relationship.getPatientID()).isEmpty()) {
            throw new AlreadyExistException("This relationship does not exist!");
        }
        relationshipRepository.delete(relationshipMergeService.dtoToEntity(relationship));
    }
}
