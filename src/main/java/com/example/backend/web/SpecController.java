package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Spec;
import com.example.backend.service.SpecService;
import com.example.backend.web.model.MyRequestBody;
import com.example.backend.web.model.StockWarning;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/spec")
public class SpecController {
    @Resource
    private SpecService specService;

    @PostMapping("/add")
    public Result addSpec(@RequestBody Spec spec){
        specService.addSpec(spec);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteSpec(@RequestBody Spec spec){
        specService.deleteSpec(spec.getSpecID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result updateSpec(@RequestBody Spec spec){
        specService.updateSpec(spec);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/warning")
    public Result stockWarning(){
        StockWarning stockWarning = specService.stockWarning();
        return ResultGenerator.genSuccessResult(stockWarning);
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        String returnValue = "start";
        try {
            String fileName = specService.saveImage(imageFile);
            returnValue = "https://from2121.com/pictures/spec/"+ fileName;
        } catch (Exception e) {
            e.printStackTrace();
            returnValue = "error";
        }
        return returnValue;
    }
}
