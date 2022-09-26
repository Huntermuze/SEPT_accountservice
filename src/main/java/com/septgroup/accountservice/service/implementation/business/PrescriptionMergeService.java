package com.septgroup.accountservice.service.implementation.business;

import com.septgroup.accountservice.dto.Prescription;
import com.septgroup.accountservice.entity.PrescriptionPOJO;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionMergeService {
    public PrescriptionPOJO prescriptionDTOToEntity(Prescription prescription, String docID, String patientID) {
        return new PrescriptionPOJO(prescription.drugName(), prescription.quantity(), prescription.pharmaceuticalCompany(), docID, patientID);
    }

    public Prescription prescriptionEntityToDTO(PrescriptionPOJO prescriptionPOJO) {
        return new Prescription(prescriptionPOJO.getDrugName(), prescriptionPOJO.getQuantity(), prescriptionPOJO.getPharmaceuticalCompany());
    }
}
