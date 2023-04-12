package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.Model.FoodCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class CartServiceImpl implements CartService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public FoodCart saveFoodCart(FoodCart foodCart) {

        FoodCart savedCart = restTemplate.postForObject("http://FOODCART-SERVICE/fooddelivery/foodcart", foodCart, FoodCart.class);

        return savedCart;

    }

    @Override
    public FoodCart getFoodCart(Integer cartId) {
        return null;
    }
}
