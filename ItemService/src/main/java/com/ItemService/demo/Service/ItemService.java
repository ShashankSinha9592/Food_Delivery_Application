package com.ItemService.demo.Service;

import com.ItemService.demo.Model.Category;
import com.ItemService.demo.Model.Item;

import java.util.List;

public interface ItemService {

    public Item addItem(Item item);

    public Item viewItem(Integer itemId);

    public Item updateItem(Item item);

    public Item removeItem(Integer itemId);

    public List<Item> viewItemsByCategory(String categoryName);

    public List<Item> viewItemsByRestaurant(Integer restaurantId);


}
