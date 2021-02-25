package com.example.backend.service.impl;

import com.example.backend.core.AbstractService;
import com.example.backend.dao.PrescriptionMapper;
import com.example.backend.model.Prescription;
import com.example.backend.service.PrescriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PrescriptionServiceImpl extends AbstractService<Prescription> implements PrescriptionService {
    @Resource
    private PrescriptionMapper prescriptionMapper;

    public void addPrescription(Prescription p){
        prescriptionMapper.addPrescription(p);
    }

    public void deleteByPrescriptionID(String prescriptionID){
        prescriptionMapper.deleteByPrescriptionID(prescriptionID);
    }

    public void updatePrescription(Prescription p){
        prescriptionMapper.updatePrescription(p);
    }

    public List<Prescription> userPrescriptionList(String userID){
        return prescriptionMapper.userPrescriptionList(userID);
    }

    public Prescription findByPrescriptionID(String prescriptionID){
        return prescriptionMapper.findByPrescriptionID(prescriptionID);
    }
}
