package com.RestaurantService.demo.Service;

import com.RestaurantService.demo.DTO.ItemsInRestaurantDTO;
import com.RestaurantService.demo.Model.Item;

import java.util.List;

public interface ItemService {

    public ItemsInRestaurantDTO addItem(Item item);

    public ItemsInRestaurantDTO viewItem(Integer itemId);

    public ItemsInRestaurantDTO updateItem(Item item);

    public boolean removeItem(Integer itemId);

    public List<Item> viewItemsByCategory(String categoryName);

    public List<ItemsInRestaurantDTO> viewItemsByRestaurant(Integer restaurantId);

    public ItemsInRestaurantDTO getDtoFromItem(Item item);


}
