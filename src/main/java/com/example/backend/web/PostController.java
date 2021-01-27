package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Post;
import com.example.backend.service.PostService;
import com.example.backend.web.model.MyRequestBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Resource
    public PostService postService;

    @PostMapping("/add")
    public Result addPost(@RequestBody Post post){
        postService.addPost(post);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        String returnValue = "start";
        try {
            String fileName = postService.saveImage(imageFile);
            returnValue = "https://from2121.com/pictures/post/"+ fileName;
        } catch (Exception e) {
            e.printStackTrace();
            returnValue = "error";
        }
        return returnValue;
    }

    @PostMapping("/list")
    public Result postList(){
        List<Post> list = postService.postList();
        return ResultGenerator.genSuccessResult(list);
    }

}
