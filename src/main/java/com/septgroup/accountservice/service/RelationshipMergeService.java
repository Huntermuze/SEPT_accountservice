package com.septgroup.accountservice.service;

import com.septgroup.accountservice.dto.Relationship;
import com.septgroup.accountservice.entity.RelationshipPOJO;
import com.septgroup.accountservice.exception.InvalidIdException;
import com.septgroup.accountservice.util.VerificationUtil;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RelationshipMergeService {
    public RelationshipPOJO dtoToEntity(Relationship relationship) throws InvalidIdException {
        UUID patientID = VerificationUtil.ifValidGetUUID(relationship.getPatientID());
        UUID doctorID = VerificationUtil.ifValidGetUUID(relationship.getDoctorID());
        return new RelationshipPOJO(patientID, doctorID);
    }

    public Relationship entityToDto(RelationshipPOJO relationshipPOJO) {
        return new Relationship(relationshipPOJO.getPatientID().toString(), relationshipPOJO.getDoctorID().toString());
    }
}
