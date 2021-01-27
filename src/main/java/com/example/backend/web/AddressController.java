package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Address;
import com.example.backend.service.AddressService;
import com.example.backend.web.model.MyRequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @PostMapping("/add")
    public Result addAddress(@RequestBody Address a){
        addressService.addAddress(a);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result deleteAddress(@RequestBody Address a){
        addressService.deleteByAddressID(a.getAddressID());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result updateAddress(@RequestBody Address a){
        addressService.updateAddress(a);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result userAddressList(@RequestBody Address a){
        List<Address> list = addressService.userAddressList(a.getUserID());
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/detail")
    public Result findByAddressID(@RequestBody Address a){
        Address address = addressService.findByAddressID(a.getAddressID());
        return ResultGenerator.genSuccessResult(address);
    }

    @PostMapping("/default")
    public Result findDefaultAdd(@RequestBody Address a){
        Address address = addressService.findDefaultAdd(a.getUserID());
        return ResultGenerator.genSuccessResult(address);
    }

    @PostMapping("/modifyDefaultAdd")
    public Result modifyDefaultAdd(@RequestBody Address a){
        addressService.modifyDefaultAdd(a.getAddressID(),a.getUserID());
        return ResultGenerator.genSuccessResult();
    }
}
