package com.RestaurantService.demo.Controller;

import com.RestaurantService.demo.DTO.RestaurantDTO;
import com.RestaurantService.demo.DTO.RestaurantsInItemDTO;
import com.RestaurantService.demo.Model.Restaurant;
import com.RestaurantService.demo.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooddelivery/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantsInItemDTO> addRestaurant(RestaurantsInItemDTO restaurant){

        RestaurantsInItemDTO registeredRestaurant = restaurantService.addRestaurant(restaurant);

        return new ResponseEntity<>(registeredRestaurant, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Restaurant> updateRestaurant(Restaurant restaurant){

        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);

        return new ResponseEntity<>(updatedRestaurant,HttpStatus.ACCEPTED);

    }

    @GetMapping("/{restaurantId}/{itemId}")
    public

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> removeRestaurant(Integer restaurantId){

        Restaurant removedRestaurant = restaurantService.removeRestaurant(restaurantId);

        return new ResponseEntity<>(removedRestaurant,HttpStatus.OK);

    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDTO> viewRestaurant(Integer restaurantId){

        RestaurantDTO restaurant = restaurantService.viewRestaurant(restaurantId);

        return new ResponseEntity<>(restaurant,HttpStatus.OK);

    }

    @GetMapping("/getnearbyRestaurant/{location}")
    public ResponseEntity<List<Restaurant>> getNearByRestaurant(String location){

        List<Restaurant> restaurants = restaurantService.viewRestaurantByLocation(location);

        return new ResponseEntity<>(restaurants,HttpStatus.OK);

    }

    @GetMapping("/getrestaurantsbyitem/{itemId}")
    public ResponseEntity<List<RestaurantsInItemDTO>> viewRestaurantByItem(Integer itemId){

        List<RestaurantsInItemDTO> restaurants = restaurantService.viewRestaurantByItem(itemId);

        return new ResponseEntity<>(restaurants,HttpStatus.OK);

    }

}
