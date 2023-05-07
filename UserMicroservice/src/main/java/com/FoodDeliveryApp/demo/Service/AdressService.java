package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.Model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ADDRESS-SERVICE")
public interface AdressService {

    @PostMapping("/fooddelivery/address")
    public Address saveAddress(@RequestBody Address address);

    @GetMapping("/fooddelivery/address/{addressId}")
    public Address getAddress(@PathVariable Integer addressId);

    @DeleteMapping("/fooddelivery/address/{addressId}")
    public Address deleteAddress(@PathVariable Integer addressId);

}
