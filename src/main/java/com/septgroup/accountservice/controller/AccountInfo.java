package com.septgroup.accountservice.controller;

import com.septgroup.accountservice.dao.AccountDAO;
import com.septgroup.accountservice.model.plural.Doctors;
import com.septgroup.accountservice.model.plural.Patients;
import com.septgroup.accountservice.model.singular.Doctor;
import com.septgroup.accountservice.model.singular.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/accountinfo")
public class AccountInfo {
    @Autowired
    private AccountDAO accountDAO;

    @GetMapping("/doctor")
    public Doctors getAllDoctors() {
        return accountDAO.getDoctors();
    }

    @GetMapping("/patient")
    public Patients getAllPatients() {
        return accountDAO.getPatients();
    }

    @GetMapping("/doctor/{userID}")
    public ResponseEntity<Object> getDoctor(@PathVariable("userID") String id) {
        var doctor = accountDAO.getDoctor(id);
        if (doctor.isEmpty()) {
            return ResponseEntity.badRequest().body("The doctor you requested does not exist!");
        }

        return ResponseEntity.ok(doctor.get());
    }

    @GetMapping("/patient/{userID}")
    public ResponseEntity<Object> getPatient(@PathVariable("userID") String id) {
        var patient = accountDAO.getDoctor(id);
        if (patient.isEmpty()) {
            return ResponseEntity.badRequest().body("The patient you requested does not exist!");
        }

        return ResponseEntity.ok(patient.get());
    }

    @PostMapping(path = "/doctor", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addDoctor(@RequestBody Doctor newDoctor) {
        if (accountDAO.getDoctor(newDoctor).isPresent()) {
            return ResponseEntity.badRequest().body(String.format("A doctor with id %s already exists!", newDoctor.getId()));
        }

        accountDAO.addDoctor(newDoctor);
        // Set the location header field to the endpoint of this new doctor.
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(newDoctor.getId())
                .toUri();

        return ResponseEntity.created(loc).build();
    }

    @PostMapping(path = "/patient", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addPatient(@RequestBody Patient newPatient) {
        if (accountDAO.getPatient(newPatient).isPresent()) {
            return ResponseEntity.badRequest().body(String.format("A patient with id %s already exists!", newPatient.getId()));
        }

        accountDAO.addPatient(newPatient);
        // Set the location header field to the endpoint of this new doctor.
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(newPatient.getId())
                .toUri();

        return ResponseEntity.created(loc).build();
    }

    @PutMapping(path = "/doctor", consumes = "application/json")
    public ResponseEntity<Object> updateDoctor(@RequestBody Doctor newDoctor) {
        var result = accountDAO.getDoctor(newDoctor);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("You cannot update a doctor (with id %s) that does not exist!", newDoctor.getId()));
        }
        Doctor docToUpdate = result.get();
        docToUpdate.setAvailability(newDoctor.getAvailability());
        docToUpdate.setEmail(newDoctor.getEmail());
        docToUpdate.setGender(newDoctor.getGender());
        docToUpdate.setClinicsWorkingAt(newDoctor.getClinicsWorkingAt());
        docToUpdate.setFirstName(newDoctor.getFirstName());
        docToUpdate.setLastName(newDoctor.getLastName());
        docToUpdate.setMobileNumber(newDoctor.getMobileNumber());

        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/patient", consumes = "application/json")
    public ResponseEntity<Object> updatePatient(@RequestBody Patient newPatient) {
        var result = accountDAO.getPatient(newPatient);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("You cannot update a patient (with id %s) that does not exist!", newPatient.getId()));
        }
        Patient patientToUpdate = result.get();
        patientToUpdate.setEmail(newPatient.getEmail());
        patientToUpdate.setGender(newPatient.getGender());
        patientToUpdate.setFirstName(newPatient.getFirstName());
        patientToUpdate.setLastName(newPatient.getLastName());
        patientToUpdate.setMobileNumber(newPatient.getMobileNumber());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/doctor/{userID}")
    public ResponseEntity<Object> deleteDoctor(@PathVariable("userID") String userID) {
        var itemFound = accountDAO.getDoctor(userID);
        if (itemFound.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("The doctor (id %s) you tried to delete does not exist!", userID));
        }

        accountDAO.removeDoctor(userID);
        return ResponseEntity.ok(itemFound);
    }

    @DeleteMapping(path = "/patient/{userID}")
    public ResponseEntity<Object> deletePatient(@PathVariable("userID") String userID) {
        var itemFound = accountDAO.getPatient(userID);
        if (itemFound.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("The patient (id %s) you tried to delete does not exist!", userID));
        }

        accountDAO.removePatient(userID);
        return ResponseEntity.ok(itemFound);
    }


}
