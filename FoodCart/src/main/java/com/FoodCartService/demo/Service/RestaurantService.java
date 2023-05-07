package com.FoodCartService.demo.Service;


import com.FoodCartService.demo.Model.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RESTAURANT-SERVICE")
public interface RestaurantService {

    @GetMapping("/fooddelivery/restaurant/{restaurantId}")
    public Restaurant getRestaurant(@PathVariable Integer restaurantId);

}
