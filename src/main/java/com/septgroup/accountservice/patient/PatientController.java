package com.septgroup.accountservice.patient;

import com.septgroup.accountservice.patient.dto.Patient;
import com.septgroup.accountservice.patient.dto.container.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/accountinfo/patient")
public class PatientController {
    @Autowired
    private PatientDAO patientDAO;

    @GetMapping
    public Patients getAllPatients() {
        return patientDAO.getPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPatient(@PathVariable("id") String id) {
        var patient = patientDAO.getPatient(id);
        if (patient.isEmpty()) {
            return ResponseEntity.badRequest().body("The patient you requested does not exist!");
        }

        return ResponseEntity.ok(patient.get());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addPatient(@RequestBody Patient newPatient) {
        if (patientDAO.getPatient(newPatient).isPresent()) {
            return ResponseEntity.badRequest().body(String.format("A patient with id %s already exists!", newPatient.getId()));
        }

        patientDAO.addPatient(newPatient);
        // Set the location header field to the endpoint of this new doctor.
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(newPatient.getId())
                .toUri();

        return ResponseEntity.created(loc).build();
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updatePatient(@RequestBody Patient newPatient) {
        var result = patientDAO.getPatient(newPatient);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("You cannot update a patient (with id %s) that does not exist!", newPatient.getId()));
        }
        Patient patientToUpdate = result.get();
        patientToUpdate.setEmail(newPatient.getEmail());
        patientToUpdate.setSex(newPatient.getSex());
        patientToUpdate.setFirstName(newPatient.getFirstName());
        patientToUpdate.setLastName(newPatient.getLastName());
        patientToUpdate.setMobileNumber(newPatient.getMobileNumber());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable("id") String id) {
        var itemFound = patientDAO.getPatient(id);
        if (itemFound.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("The patient (id %s) you tried to delete does not exist!", id));
        }

        patientDAO.removePatient(id);
        return ResponseEntity.ok(itemFound);
    }
}
