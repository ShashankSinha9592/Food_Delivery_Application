package com.RestaurantService.demo.Service;

import com.RestaurantService.demo.DTO.RestaurantDTO;
import com.RestaurantService.demo.DTO.RestaurantsInItemDTO;
import com.RestaurantService.demo.Model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public RestaurantsInItemDTO addRestaurant(RestaurantsInItemDTO restaurant);

    public Restaurant updateRestaurant(Restaurant restaurant);

    public Restaurant removeRestaurant(Integer restaurantId);

    public RestaurantDTO viewRestaurant(Integer restaurantId);

    public List<Restaurant> viewRestaurantByLocation(String location);

    public List<RestaurantsInItemDTO> viewRestaurantByItem(Integer itemId);

    public Restaurant addItemToRestaurantMenu(Integer itemId, Integer restaurantId);

}
