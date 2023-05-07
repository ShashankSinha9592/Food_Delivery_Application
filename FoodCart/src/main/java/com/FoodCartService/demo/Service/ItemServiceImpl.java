package com.FoodCartService.demo.Service;

import com.FoodCartService.demo.DTO.ItemDTO;
import com.FoodCartService.demo.Exceptions.ItemException;
import com.FoodCartService.demo.Model.Category;
import com.FoodCartService.demo.Model.Item;
import com.FoodCartService.demo.Repository.ItemRepository;
import jakarta.persistence.Embedded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item addItem(ItemDTO itemDTO) {

        Item item = getItemFromDTO(itemDTO);

        return itemRepository.save(item);

    }

    public Item getItemFromDTO(ItemDTO itemDTO){

        Item item = new Item();

        item.setItemId(itemDTO.getItemId());

        item.setItemName(itemDTO.getItemName());

        item.setCategory(itemDTO.getCategory());

        item.setQuantity(itemDTO.getQuantity());

        item.setCost(itemDTO.getCost());

        item.setRestaurantId(itemDTO.getRestaurant().getRestaurantId());

        item.setFoodCart(itemDTO.getFoodCart());

        return item;

    }

    @Override
    public Item validateItem(Integer cartItemId) {

        return itemRepository.findById(cartItemId).orElseThrow(()-> new ItemException("Invalid Item Id"+cartItemId));

    }

    @Override
    public void removeItem(Integer cartItemId, Integer cartId) {

//        itemRepository.deleteItemFromCart(itemId,cartId);


    }
}
