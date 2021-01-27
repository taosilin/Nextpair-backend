package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.User;
import com.example.backend.service.UserService;
import com.example.backend.web.model.MyRequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        User u = userService.findByUserID(user.getUserID());
        if (u==null){
            userService.addUser(user);
            return ResultGenerator.genSuccessResult("添加成功！");
        }
        else{
            return ResultGenerator.genSuccessResult("该用户已存在！");
        }
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody MyRequestBody myRequestBody) {
        User user = userService.findByUserID(myRequestBody.userID);
        return ResultGenerator.genSuccessResult(user);
    }
}
