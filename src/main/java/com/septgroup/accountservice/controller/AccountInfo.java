package com.septgroup.accountservice.controller;

import com.septgroup.accountservice.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accountinfo")
public class AccountInfo {
    @Autowired
    private AccountDAO accountDAO;

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

    @PostMapping("/doctor/{userID}")
    public ResponseEntity<Object> addDoctor() {
        //TODO
        return null;
    }

    @PostMapping("/patient/{userID}")
    public ResponseEntity<Object> addPatient() {
        // TODO
        return null;
    }

}
