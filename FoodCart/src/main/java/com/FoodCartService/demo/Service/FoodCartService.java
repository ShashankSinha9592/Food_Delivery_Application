package com.FoodCartService.demo.Service;

import com.FoodCartService.demo.DTO.FoodCartDTO;
import com.FoodCartService.demo.Model.FoodCart;
import com.FoodCartService.demo.Model.Item;

public interface FoodCartService {


    public FoodCartDTO createCartForUser(FoodCartDTO foodCartDTO);

    public FoodCartDTO viewCart(Integer cartId);

    public FoodCartDTO removeCart(Integer cartId);
    public FoodCart getCartOfUser(Integer userId);

    public FoodCart addItemToCart(Integer cartId, Integer itemId,Integer restaurantId);

    public FoodCart increaseOrReduceQuantityOfItem(Integer cartId, Integer itemId, Integer quantity);

    public Item removeItemFromCart(Integer cartItemId);

    public FoodCart clearCart(Integer cartId);

}
