package com.septgroup.accountservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.septgroup.accountservice.entity.DoctorPOJO;
import com.septgroup.accountservice.repository.*;

@SpringBootTest
class AccountserviceApplicationTests {

	@Autowired
	private DoctorRepository doctorRepository;

	@Test
	public void saveDoctorTest() {
		UUID id = new UUID(123456, 123456);
		DoctorPOJO doctor = new DoctorPOJO(id, "testemail123456@example.com", "Michael", "Huntington", "1234567890", "Herbie's Hotdogs");

		doctorRepository.save(doctor);

		assertTrue(doctorRepository.existsById(id));

		doctorRepository.deleteById(id);
	}

	@Test
	public void deleteDoctorTest() {
		UUID id = new UUID(123456, 123456);
		DoctorPOJO doctor = new DoctorPOJO(id, "testemail123456@example.com", "Michael", "Huntington", "1234567890", "Herbie's Hotdogs");

		doctorRepository.save(doctor);
		assertTrue(doctorRepository.existsById(id));
		doctorRepository.deleteById(id);

		assertFalse(doctorRepository.existsById(id));
	}

}
