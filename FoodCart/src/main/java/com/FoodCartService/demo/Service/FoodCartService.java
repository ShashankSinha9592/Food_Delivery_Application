package com.FoodCartService.demo.Service;

import com.FoodCartService.demo.DTO.FoodCartDTO;
import com.FoodCartService.demo.Model.FoodCart;
import com.FoodCartService.demo.Model.Item;

public interface FoodCartService {


    public FoodCartDTO createCartForUser(FoodCartDTO foodCartDTO);

    public FoodCart addItemToCart(Integer cartId, Integer itemId,Integer restaurantId);

    public FoodCart increaseOrReduceQuantityOfItem(Integer cartId, Integer itemId, Integer quantity);

    public FoodCart removeItemFromCart(Integer cartId, Integer itemId);

    public FoodCart clearCart(Integer cartId);

}
