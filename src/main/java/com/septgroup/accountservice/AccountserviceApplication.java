package com.septgroup.accountservice;

import com.septgroup.accountservice.model.singular.Doctor;
import com.septgroup.accountservice.model.singular.Patient;
import com.septgroup.accountservice.model.singular.Prescription;
import com.septgroup.accountservice.model.singular.User;
import com.septgroup.accountservice.repository.PatientRepository;
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
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
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
