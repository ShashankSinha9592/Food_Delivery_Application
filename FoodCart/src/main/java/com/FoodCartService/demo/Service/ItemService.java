package com.FoodCartService.demo.Service;

import com.FoodCartService.demo.DTO.ItemDTO;
import com.FoodCartService.demo.Model.Item;

public interface ItemService {

    public ItemDTO addItem(ItemDTO itemDTO);

    public Item getItemFromDTO(ItemDTO itemDTO);

    public Item validateItem(Integer itemId);

    public void removeItem(Integer itemId, Integer cartId);

}
