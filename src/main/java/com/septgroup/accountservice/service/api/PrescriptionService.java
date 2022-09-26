package com.septgroup.accountservice.service.api;

import com.septgroup.accountservice.dto.Prescription;
import com.septgroup.accountservice.exception.InvalidIdException;
import com.septgroup.accountservice.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrescriptionService {

    List<Prescription> getPrescriptionsForPatient(String patientID) throws InvalidIdException;

    List<Prescription> getPrescribedByDoctor(String doctorID) throws InvalidIdException;

    void prescribeToPatient(Prescription prescription, String doctorID, String patientID) throws InvalidIdException;

    void removePrescription(Prescription prescription, String doctorID, String patientID) throws InvalidIdException, NotFoundException;

    void removeAllPatientPrescriptions(String patientID);

    void removeAllDoctorPrescriptions(String doctorID);
}
