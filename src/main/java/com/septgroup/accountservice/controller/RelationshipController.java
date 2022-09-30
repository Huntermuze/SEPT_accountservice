package com.septgroup.accountservice.controller;

import com.septgroup.accountservice.dto.Relationship;
import com.septgroup.accountservice.service.api.RelationshipService;
import com.septgroup.accountservice.util.VerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/accountinfo/relationship")
public class RelationshipController {
    @Autowired
    RelationshipService relationshipService;

    @GetMapping("/{id}/doctors")
    public ResponseEntity<Object> getDoctorsOfPatient(@PathVariable("id") String id) {
        VerificationUtil.throwIfNotValid(id);
        return ResponseEntity.ok(relationshipService.getAllDoctors(id));
    }

    @GetMapping("/{id}/patients")
    public ResponseEntity<Object> getPatientsOfDoctor(@PathVariable("id") String id) {
        VerificationUtil.throwIfNotValid(id);
        return ResponseEntity.ok(relationshipService.getAllPatients(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createRelationship(@RequestBody Relationship relationship) {
        relationshipService.createRelationship(relationship);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().build().toUri()).build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteRelationship(@RequestBody Relationship relationship) {
        relationshipService.deleteRelationship(relationship);
        return ResponseEntity.ok(relationship);
    }
}
