package com.septgroup.accountservice.repository;

import com.septgroup.accountservice.model.singular.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
}
