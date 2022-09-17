package com.septgroup.accountservice.patient;

import com.septgroup.accountservice.patient.dto.Patient;
import com.septgroup.accountservice.patient.dto.container.Patients;
import com.septgroup.accountservice.exception.AlreadyExistException;
import com.septgroup.accountservice.exception.NotFoundException;
import com.septgroup.accountservice.shared.dto.User;
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
    public Patients getAllPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPatient(@PathVariable("id") String id) {
        Patient patient = patientService.getPatient(id).orElseThrow(() -> new NotFoundException("The patient you requested does not exist!"));
        return ResponseEntity.ok(patient);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addPatient(@RequestBody Patient newPatient) {
        if (patientService.getPatient(newPatient).isPresent()) {
            throw new AlreadyExistException(String.format("A patient with prescription_id %s already exists!", newPatient.getId()));
        }

        patientService.addPatient(newPatient);
        // Set the location header field to the endpoint of this new patient.
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(newPatient.getId())
                .toUri();

        return ResponseEntity.created(loc).build();
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updatePatient(@RequestBody Patient newPatient) {
        Patient patientToUpdate = patientService.getPatient(newPatient)
                .orElseThrow(() -> new NotFoundException(
                        String.format("You cannot update a patient (with prescription_id %s) that does not exist!", newPatient.getId())));
        patientToUpdate.setEmail(newPatient.getEmail());
        patientToUpdate.setSex(newPatient.getSex());
        patientToUpdate.setDOB(newPatient.getDOB());
        patientToUpdate.setPrescriptions(newPatient.getPrescriptions());
        patientToUpdate.setHealthStatus(newPatient.getHealthStatus());
        patientToUpdate.setFirstName(newPatient.getFirstName());
        patientToUpdate.setLastName(newPatient.getLastName());
        patientToUpdate.setMobileNumber(newPatient.getMobileNumber());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable("id") String id) {
        Patient patient = patientService.getPatient(id).orElseThrow(() -> new NotFoundException(String.format("The patient (prescription_id %s) you tried to delete does not exist!", id)));
        patientService.removePatient(patient);
        return ResponseEntity.ok(patient);
    }
}
