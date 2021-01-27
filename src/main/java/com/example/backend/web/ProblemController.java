package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Problem;
import com.example.backend.service.ProblemService;
import com.example.backend.web.model.MyRequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Resource
    private ProblemService problemService;

    @PostMapping("/add")
    public Result addProblem(@RequestBody Problem problem){
        problemService.addProblem(problem);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result problemList(@RequestBody MyRequestBody myRequestBody){
        List<Problem> list = problemService.problemList(myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/update")
    public Result updateProblem(@RequestBody Problem problem){
        problemService.updateProblem(problem);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteProblem(@RequestBody Problem problem){
        problemService.deleteProblem(problem.getProblemID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/total")
    public Integer problemTotal(){
        return problemService.problemTotal();
    }
}
