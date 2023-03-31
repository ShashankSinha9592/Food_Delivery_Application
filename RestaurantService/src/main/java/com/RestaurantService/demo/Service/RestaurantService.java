package com.RestaurantService.demo.Service;

import com.RestaurantService.demo.Model.Restaurant;

import java.util.List;

public interface RestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant);

    public Restaurant updateRestaurant(Restaurant restaurant);

    public Restaurant removeRestaurant(Integer restaurantId);

    public Restaurant viewRestaurant(Integer restaurantId);

    public List<Restaurant> viewRestaurantByLocation(String location);

    public List<Restaurant> viewRestaurantByItem(Integer itemId);

}
