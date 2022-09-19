package com.septgroup.accountservice.repository;

import com.septgroup.accountservice.entity.DoctorPOJO;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends UserRepository<DoctorPOJO, UUID> {
}
