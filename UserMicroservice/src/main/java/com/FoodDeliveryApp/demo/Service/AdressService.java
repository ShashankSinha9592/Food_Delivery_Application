package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.Model.Address;

public interface AdressService {

    public Address saveAddress(Address address);

    public Address getAddress(Integer addressId);

}
