package com.septgroup.accountservice;

import com.septgroup.accountservice.doctor.dto.Doctor;
import com.septgroup.accountservice.patient.dto.Patient;
import com.septgroup.accountservice.patient.dto.Prescription;
import com.septgroup.accountservice.shared.dto.User;
import com.septgroup.accountservice.shared.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class AccountserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository patientRepository) {
        return args -> {
            Patient patient = new Patient(
                    "hah",
                    "adad",
                    "akda", User.Sex.MALE,
                    "0412312321",
                    Date.from(Instant.now()),
                    List.of(new Prescription("ada", 13, "fjaf", new Doctor())),
                    User.HealthStatus.GOOD);
            patientRepository.save(patient);
        };
    }

}
