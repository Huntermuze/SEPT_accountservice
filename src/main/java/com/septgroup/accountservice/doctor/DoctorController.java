package com.septgroup.accountservice.doctor;

import com.septgroup.accountservice.doctor.dto.Doctor;
import com.septgroup.accountservice.doctor.dto.container.Doctors;
import com.septgroup.accountservice.exception.AlreadyExistException;
import com.septgroup.accountservice.exception.NotFoundException;
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
    public Doctors getAllDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoctor(@PathVariable("id") String id) {
        Doctor doctor = doctorService.getDoctor(id).orElseThrow(() -> new NotFoundException("The doctor you requested does not exist!"));
        return ResponseEntity.ok(doctor);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addDoctor(@RequestBody Doctor newDoctor) {
        if (doctorService.getDoctor(newDoctor).isPresent()) {
            throw new AlreadyExistException(String.format("A doctor with prescription_id %s already exists!", newDoctor.getId()));
        }

        doctorService.addDoctor(newDoctor);
        // Set the location header field to the endpoint of this new doctor.
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(newDoctor.getId())
                .toUri();
        return ResponseEntity.created(loc).build();
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<Object> updateDoctor(@RequestBody Doctor newDoctor) {
        Doctor docToUpdate = doctorService.getDoctor(newDoctor)
                .orElseThrow(() -> new NotFoundException(
                        String.format("You cannot update a doctor (with prescription_id %s) that does not exist!", newDoctor.getId())));
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
        Doctor doctor = doctorService.getDoctor(id).orElseThrow(() -> new NotFoundException(String.format("The doctor (prescription_id %s) you tried to delete does not exist!", id)));
        doctorService.removeDoctor(doctor);
        return ResponseEntity.ok(doctor);
    }
}
