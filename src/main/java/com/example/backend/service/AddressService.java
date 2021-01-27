package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Address;
import java.util.List;
public interface AddressService extends Service<Address>{
    void addAddress(Address a);
    void deleteByAddressID(String addressID);
    void updateAddress(Address a);
    List<Address> userAddressList(String userID);
    Address findByAddressID(String addressID);
    Address findDefaultAdd(String userID);
    void modifyDefaultAdd(String addressID,String userID);
}
