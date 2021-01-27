package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Frame;
import com.example.backend.model.Like;
import com.example.backend.model.Product;
import com.example.backend.service.LikeService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Resource
    private LikeService likeService;

    @PostMapping("/add")
    public Result addLike(@RequestBody Like like){
        likeService.addLike(like);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteLike(@RequestBody Like like){
        likeService.deleteLike(like);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result likeList(@RequestBody Like like){
        List<Product> list = likeService.likeList(like.getUserID());
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/frame")
    public Result likeFrameList(@RequestBody Like like){
        List<Frame> list = likeService.likeFrameList(like.getUserID());
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/findUserIsLike")
    public Result findUserIsLike(@RequestBody Like like){
        int i = likeService.findUserIsLike(like.getUserID(),like.getProductID());
        return ResultGenerator.genSuccessResult(i>0?true:false);
    }
}
