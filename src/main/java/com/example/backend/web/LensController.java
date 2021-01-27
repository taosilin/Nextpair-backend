package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Lens;
import com.example.backend.service.LensService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/lens")
public class LensController {
    @Resource
    private LensService lensService;

    @PostMapping("/add")
    public Result addLens(@RequestBody Lens lens){
        lensService.addLens(lens);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result lensList(@RequestBody MyRequestBody myRequestBody){
        List<Lens> list = lensService.lensList(myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/update")
    public Result updateLens(@RequestBody Lens lens){
        lensService.updateLens(lens);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteLens(@RequestBody Lens lens){
        lensService.deleteLens(lens.getLensID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result findByLensID(@RequestBody Lens l){
        Lens lens = lensService.findByLensID(l.getLensID());
        return ResultGenerator.genSuccessResult(lens);
    }

    @PostMapping("/total")
    public Integer lensTotal(){
        return lensService.lensTotal();
    }
}
