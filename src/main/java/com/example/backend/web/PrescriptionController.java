package com.example.backend.web;
import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Prescription;
import com.example.backend.service.PrescriptionService;
import com.example.backend.web.model.MyRequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Resource
    private PrescriptionService prescriptionService;

    @PostMapping("/add")
    public Result addPrescription(@RequestBody Prescription p){
        prescriptionService.addPrescription(p);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteByPrescriptionID(@RequestBody Prescription p){
        prescriptionService.deleteByPrescriptionID(p.getPrescriptionID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result updatePrescription(@RequestBody Prescription p){
        prescriptionService.updatePrescription(p);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result userPrescriptionList(@RequestBody Prescription p){
        List<Prescription> list = prescriptionService.userPrescriptionList(p.getUserID());
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/detail")
    public Result findByPrescriptionID(@RequestBody Prescription p){
        Prescription prescription = prescriptionService.findByPrescriptionID(p.getPrescriptionID());
        return ResultGenerator.genSuccessResult(prescription);
    }
}
