package com.septgroup.accountservice.doctor;

import com.septgroup.accountservice.doctor.dto.Doctor;
import com.septgroup.accountservice.doctor.dto.container.Doctors;
import com.septgroup.accountservice.shared.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("DoctorDAO")
public class DoctorDAO {
    // TODO either use CrudRepository OR EntityManager. Decide tomorrow. Setup DAO and Service layers. Put service classes
    //  in respective feature package.
    @Autowired
    DoctorRepository doctorRepository;
    private static final Doctors doctorsList = new Doctors();

    public User getDoctors() {
        return doctorRepository.findAll();
//        return doctorsList;
    }

    public Optional<User> getDoctor(String id) {
        return doctorsList.getDoctors().stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public Optional<User> getDoctor(Doctor doc) {
        return doctorsList.getDoctors().stream().filter(d -> d.getId().equals(doc.getId())).findFirst();
    }

    public void addDoctor(User doc) {
        // Also add to database.
        doctorsList.getDoctors().add(doc);
    }

    public void removeDoctor(User doc) {
        doctorsList.getDoctors().remove(doc);
    }

    public void removeDoctor(String id) {
        var found = doctorsList.getDoctors().stream().filter(d -> d.getId().equals(id)).findFirst();
        found.ifPresent(doctor -> doctorsList.getDoctors().remove(doctor));
    }
}
