package com.FoodCartService.demo.Service;

import com.FoodCartService.demo.Model.FoodCart;
import com.FoodCartService.demo.Model.Item;

public interface FoodCartService {

    public FoodCart addItemToCart(Integer cartId, Item item);

    public FoodCart increaseOrReduceQuantityOfItem(Integer cartId, Integer itemId, Integer quantity);

    public FoodCart removeItemFromCart(Integer cartId, Integer itemId);

    public FoodCart clearCart(Integer cartId);

}
