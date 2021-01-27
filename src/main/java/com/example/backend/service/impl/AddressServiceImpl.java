package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.AddressMapper;
import com.example.backend.model.Address;
import com.example.backend.service.AddressService;
import com.example.backend.core.AbstractService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl extends AbstractService<Address> implements AddressService{
    @Resource
    private AddressMapper addressMapper;

    public void addAddress(Address a){

        if (addressMapper.findDefaultAdd(a.getUserID())==null){
            a.setDefaultAdd("1");
        }

        addressMapper.addAddress(a);


    }

    public void deleteByAddressID(String addressID){
        addressMapper.deleteByAddressID(addressID);
    }

    public void updateAddress(Address a){
        addressMapper.updateAddress(a);
    }

    public List<Address> userAddressList(String userID){
        return addressMapper.userAddressList(userID);
    }

    public Address findByAddressID(String addressID){
        return addressMapper.findByAddressID(addressID);
    }

    public Address findDefaultAdd(String userID){
        return addressMapper.findDefaultAdd(userID);
    }

    public void modifyDefaultAdd(String addressID,String userID){
        Address address = addressMapper.findDefaultAdd(userID);
        addressMapper.modifyDefaultAdd(address.getAddressID(),"0");
        addressMapper.modifyDefaultAdd(addressID,"1");
    }
}
