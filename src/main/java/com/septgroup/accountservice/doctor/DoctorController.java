package com.septgroup.accountservice.doctor;

import com.septgroup.accountservice.doctor.dto.Doctor;
import com.septgroup.accountservice.doctor.dto.container.Doctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/accountinfo/doctor")
public class DoctorController {
    @Autowired
    private DoctorDAO doctorDAO;

    @GetMapping
    public Doctors getAllDoctors() {
        return doctorDAO.getDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoctor(@PathVariable("id") String id) {
        var doctor = doctorDAO.getDoctor(id);
        if (doctor.isEmpty()) {
            return ResponseEntity.badRequest().body("The doctor you requested does not exist!");
        }

        return ResponseEntity.ok(doctor.get());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addDoctor(@RequestBody Doctor newDoctor) {
        if (doctorDAO.getDoctor(newDoctor).isPresent()) {
            return ResponseEntity.badRequest().body(String.format("A doctor with id %s already exists!", newDoctor.getId()));
        }

        doctorDAO.addDoctor(newDoctor);
        // Set the location header field to the endpoint of this new doctor.
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(newDoctor.getId())
                .toUri();

        return ResponseEntity.created(loc).build();
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updateDoctor(@RequestBody Doctor newDoctor) {
        var result = doctorDAO.getDoctor(newDoctor);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("You cannot update a doctor (with id %s) that does not exist!", newDoctor.getId()));
        }
        Doctor docToUpdate = result.get();
        docToUpdate.setEmail(newDoctor.getEmail());
        docToUpdate.setSex(newDoctor.getSex());
        docToUpdate.setClinicWorkingAt(newDoctor.getClinicWorkingAt());
        docToUpdate.setFirstName(newDoctor.getFirstName());
        docToUpdate.setLastName(newDoctor.getLastName());
        docToUpdate.setMobileNumber(newDoctor.getMobileNumber());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteDoctor(@PathVariable("id") String id) {
        var itemFound = doctorDAO.getDoctor(id);
        if (itemFound.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("The doctor (id %s) you tried to delete does not exist!", id));
        }

        doctorDAO.removeDoctor(id);
        return ResponseEntity.ok(itemFound);
    }
}
