package com.septgroup.accountservice.controller;

import com.septgroup.accountservice.dto.Clinic;
import com.septgroup.accountservice.service.api.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
    @Autowired
    ClinicService clinicService;

    @GetMapping()
    public ResponseEntity<Object> getAllClinics() {
        return ResponseEntity.ok(clinicService.getAllClinics());
    }

    @GetMapping("/{clinicName}")
    public ResponseEntity<Object> getClinic(@PathVariable("clinicName") String clinicName) {
        return ResponseEntity.ok(clinicService.getClinic(clinicName));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addClinic(@RequestBody Clinic newClinic) {
        clinicService.addClinic(newClinic);
        // Set the location header field to the endpoint of this new clinic.
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(newClinic.clinicName())
                .toUri();
        return ResponseEntity.created(loc).build();
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updateClinic(@RequestBody Clinic newClinic) {
        clinicService.updateClinic(newClinic);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{clinicName}")
    public ResponseEntity<Object> deleteClinic(@PathVariable String clinicName) {
        Clinic clinic = clinicService.getClinic(clinicName);
        clinicService.deleteClinic(clinicName);
        return ResponseEntity.ok(clinic);
    }
}
