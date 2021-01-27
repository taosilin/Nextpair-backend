package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.LensStock;
import com.example.backend.service.LensStockService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static java.lang.Math.abs;

@RestController
@RequestMapping("/lensstock")
public class LensStockController {
    @Resource
    private LensStockService lensStockService;

    @PostMapping("/add")
    public Result addLensStock(@RequestBody LensStock lensStock){
        lensStockService.addLensStock(lensStock);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result updateLensStock(@RequestBody LensStock lensStock){
        lensStockService.updateLensStock(lensStock);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteLensStock(@RequestBody LensStock lensStock){
        lensStockService.deleteLensStock(lensStock.getStockID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result stockList(@RequestBody MyRequestBody myRequestBody){
        List<LensStock> list = lensStockService.stockList(myRequestBody.userID, myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/cyl")
    public Result cylFilter(@RequestBody LensStock lensStock){
        List<List<Integer>> list = lensStockService.cylFilter(lensStock.getLensID());
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/total")
    public Integer lensStockTotal(@RequestBody LensStock lensStock){
        return lensStockService.lensStockTotal(lensStock.getLensID());
    }
//    @PostMapping("/adddata")
//    public Result adddata(@RequestBody LensStock lensStock){
//
//        Integer i,j;
//        String lensID = lensStock.getLensID();
//        for (i=-1200;i<=1200;i=i+25){
//            for (j=-600;j<=0;j=j+25){
//                LensStock l = new LensStock();
//                l.setStockID(lensID+"_"+i.toString()+"_"+j.toString());
//                l.setLensID(lensID);
//                l.setSph(i.doubleValue()/100);
//                l.setCyl(j.doubleValue()/100);
//                l.setStock(abs(i+j));
//                lensStockService.addLensStock(l);
//            }
//        }
//
//
//        return ResultGenerator.genSuccessResult();
//    }
}
