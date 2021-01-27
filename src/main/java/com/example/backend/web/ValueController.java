package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Value;
import com.example.backend.service.ValueService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/value")
public class ValueController {
    @Resource
    private ValueService valueService;

    @PostMapping("/add")
    public Result addValue(@RequestBody Value value){
        valueService.addValue(value);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/attribute")
    public Result findByAttribute(@RequestBody Value value){
        List<Value> list = valueService.findByAttribute(value.getAttributeID());
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/delete")
    public Result deleteValue(@RequestBody Value value){
        valueService.deleteValue(value.getValueID());
        return ResultGenerator.genSuccessResult();
    }
}
