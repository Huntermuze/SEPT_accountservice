package com.septgroup.accountservice.doctor;

import com.septgroup.accountservice.doctor.entity.DoctorPOJO;
import com.septgroup.accountservice.shared.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends UserRepository<DoctorPOJO, UUID> {
}
