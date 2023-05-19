package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.DTO.FoodCartDTO;
import com.FoodDeliveryApp.demo.Model.FoodCart;
import jakarta.transaction.Transactional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "FOODCART-SERVICE")
public interface CartService {

    @PostMapping("/fooddelivery/foodcart")
    public FoodCartDTO saveFoodCart(@RequestBody FoodCartDTO foodCartDTO);

    @DeleteMapping("/fooddelivery/foodcart/{cartId}")
    public FoodCartDTO removeCart(@PathVariable Integer cartId);

}
