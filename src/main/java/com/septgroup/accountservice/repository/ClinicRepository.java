package com.septgroup.accountservice.repository;

import com.septgroup.accountservice.entity.ClinicPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<ClinicPOJO, Long> {
}
