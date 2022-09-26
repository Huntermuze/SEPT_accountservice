package com.septgroup.accountservice.controller;

import com.septgroup.accountservice.service.api.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    PrescriptionService prescriptionService;

    @GetMapping("/doctor/{doctorID}")
    public ResponseEntity<Object> getAllPrescribedMedicine(@PathVariable("doctorID") String doctorID) {
        return ResponseEntity.ok(prescriptionService.getPrescribedByDoctor(doctorID));
    }

    @GetMapping("patient/{patientID}")
    public ResponseEntity<Object> getAllPrescriptionsReceived(@PathVariable("patientID") String patientID) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionsForPatient(patientID));
    }
}
