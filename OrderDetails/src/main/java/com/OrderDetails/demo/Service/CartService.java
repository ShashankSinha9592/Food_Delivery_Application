package com.OrderDetails.demo.Service;

import com.OrderDetails.demo.Model.FoodCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FOODCART-SERVICE")
public interface CartService {

    @GetMapping("/fooddelivery/foodcart/{cartId}")
    public FoodCart getCart(@PathVariable Integer cartId);

}
