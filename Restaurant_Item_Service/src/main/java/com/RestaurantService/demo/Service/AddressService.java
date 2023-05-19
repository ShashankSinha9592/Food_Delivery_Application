package com.RestaurantService.demo.Service;

import com.RestaurantService.demo.Model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ADDRESS-SERVICE")
public interface AddressService {

    @PostMapping("/fooddelivery/address")
    public Address saveAddress(@RequestBody Address address);

    @GetMapping("/fooddelivery/address/{addressId}")
    public Address getAddress(@PathVariable Integer addressId);

    @DeleteMapping("/fooddelivery/address/{addressId}")
    public Address deleteAddress(@PathVariable Integer addressId);

}
