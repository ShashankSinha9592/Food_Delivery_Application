package com.FoodDeliveryApp.demo.Service;

import com.FoodDeliveryApp.demo.Model.FoodCart;

public interface CartService {

    public FoodCart saveFoodCart(FoodCart foodCart);

    public FoodCart getFoodCart(Integer cartId);

}
