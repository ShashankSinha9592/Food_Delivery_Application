package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.Model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class AddressServiceImpl implements AdressService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Address saveAddress(Address address) {

        Address savedAddress = restTemplate.postForObject("http://ADDRESS-SERVICE/fooddelivery",address, Address.class);

        return savedAddress;

    }

    @Override
    public Address getAddress(Integer addressId) {
        return null;
    }
}
