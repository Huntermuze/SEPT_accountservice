package com.septgroup.accountservice.controller;

import com.septgroup.accountservice.dto.Patient;
import com.septgroup.accountservice.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/accountinfo/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<Object> getAllPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPatient(@PathVariable("id") String id) {
        Patient patient = patientService.getPatient(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addPatient(@RequestBody Patient newPatient) {
        patientService.addPatient(newPatient);
        // Set the location header field to the endpoint of this new patient.
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(newPatient.getId())
                .toUri();
        return ResponseEntity.created(loc).build();
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updatePatient(@RequestBody Patient newPatient) {
        patientService.updatePatient(newPatient);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable("id") String patientID) {
        Patient patient = patientService.getPatient(patientID);
        patientService.removePatient(patientID);
        return ResponseEntity.ok(patient);
    }
}
