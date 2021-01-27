package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Attribute;
import com.example.backend.service.AttributeService;
import com.example.backend.web.model.MyRequestBody;
import com.example.backend.web.model.ValueList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
    @Resource
    private AttributeService attributeService;

    @PostMapping("/add")
    public Result addAttribute(@RequestBody Attribute attribute){
        attributeService.addAttribute(attribute);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result attributeDetail(@RequestBody Attribute attribute){
        List<ValueList> list = attributeService.attributeDetail(attribute);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/delete")
    public Result deleteAttribute(@RequestBody Attribute attribute){
        attributeService.deleteAttribute(attribute.getAttributeID());
        return ResultGenerator.genSuccessResult();
    }
}
