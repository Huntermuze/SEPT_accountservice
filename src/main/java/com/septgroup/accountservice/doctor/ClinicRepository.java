package com.septgroup.accountservice.doctor;

import com.septgroup.accountservice.doctor.entity.ClinicPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<ClinicPOJO, Long> {
}
