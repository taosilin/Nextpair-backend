package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper extends Mapper<Address>{
    public void addAddress(Address a);
    public void deleteByAddressID(String addressID);
    public void updateAddress(Address a);
    public List<Address> userAddressList(String userID);
    public Address findByAddressID(@Param("addressID") String addressID);
    public Address findDefaultAdd(@Param("userID")String userID); // 查找用户默认地址
    public void modifyDefaultAdd(@Param("addressID")String addressID,@Param("defaultAdd")String defaultAdd); // 修改默认地址
}
