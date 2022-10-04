package com.septgroup.accountservice.controller;

import com.septgroup.accountservice.dto.Doctor;
import com.septgroup.accountservice.service.api.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/accountinfo/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<Object> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoctor(@PathVariable("id") String id) {
        Doctor doctor = doctorService.getDoctor(id);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addDoctor(@RequestBody Doctor newDoctor) {
        doctorService.addDoctor(newDoctor);
        // Set the location header field to the endpoint of this new doctor.
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(newDoctor.getId())
                .toUri();
        return ResponseEntity.created(loc).build();
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updateDoctor(@RequestBody Doctor newDoctor) {
        doctorService.updateDoctor(newDoctor);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteDoctor(@PathVariable("id") String doctorID) {
        Doctor doctor = doctorService.getDoctor(doctorID);
        doctorService.removeDoctor(doctorID);
        return ResponseEntity.ok(doctor);
    }
}
