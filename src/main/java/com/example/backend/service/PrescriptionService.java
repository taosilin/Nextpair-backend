package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Prescription;

import java.util.List;

public interface PrescriptionService extends Service<Prescription> {
    void addPrescription(Prescription p);
    void deleteByPrescriptionID(String prescriptionID);
    void updatePrescription(Prescription p);
    List<Prescription> userPrescriptionList(String userID);
    public Prescription findByPrescriptionID(String prescriptionID);
}
