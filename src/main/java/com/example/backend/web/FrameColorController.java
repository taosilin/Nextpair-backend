package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.FrameColor;
import com.example.backend.service.FrameColorService;
import com.example.backend.web.model.MyRequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/framecolor")
public class FrameColorController {
    @Resource
    private FrameColorService frameColorService;

    @PostMapping("/add")
    public Result addFrameColor(@RequestBody FrameColor frameColor){
        frameColorService.addFrameColor(frameColor);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result updateFrameColor(@RequestBody FrameColor frameColor){
        frameColorService.updateFrameColor(frameColor);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteFrameColor(@RequestBody FrameColor frameColor){
        frameColorService.deleteFrameColor(frameColor.getFrameID(),frameColor.getColorID());
        return ResultGenerator.genSuccessResult();
    }
}
