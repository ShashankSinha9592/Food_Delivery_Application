package com.RestaurantService.demo.Service;

import com.RestaurantService.demo.DTO.ItemDTO;
import com.RestaurantService.demo.DTO.ItemsInRestaurantDTO;
import com.RestaurantService.demo.DTO.RestaurantDTO;
import com.RestaurantService.demo.Exceptions.ItemException;
import com.RestaurantService.demo.Exceptions.RestaurantException;
import com.RestaurantService.demo.Model.Category;
import com.RestaurantService.demo.Model.Item;
import com.RestaurantService.demo.Model.Restaurant;
import com.RestaurantService.demo.Repository.ItemRepository;
import com.RestaurantService.demo.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public ItemsInRestaurantDTO addItem(Item item) {

        Item savedItem = itemRepository.save(item);

        ItemsInRestaurantDTO itemDTO = getDtoFromItem(savedItem);

        return itemDTO;

    }

    @Override
    public ItemsInRestaurantDTO viewItem(Integer itemId) {

        Item item = itemRepository.findById(itemId).orElseThrow(()-> new ItemException("Item does not exists with item id : "+itemId));

        return getDtoFromItem(item);

    }

    @Override
    public ItemsInRestaurantDTO updateItem(Item item) {

        Item validatedItem = itemRepository.findById(item.getItemId()).orElseThrow(()-> new ItemException("Item does not exists with item id : "+item.getItemId()));

        validateCategory(item.getCategoryId());

        Item updatedItem = itemRepository.save(item);

        return getDtoFromItem(updatedItem);
    }

    @Override
    public boolean removeItem(Integer itemId) {

        Item validatedItem = itemRepository.findById(itemId).orElseThrow(()-> new ItemException("Item does not exists with item id : "+itemId));

        itemRepository.delete(validatedItem);

        return true;

    }

    @Override
    public List<Item> viewItemsByCategory(String categoryName) {

        Category category = restTemplate.getForObject("http://CATEGORY-SERVICE/name/"+categoryName, Category.class);

        if(category==null) throw new RuntimeException("Category does not exists with name :"+categoryName);

        List<Item> items = itemRepository.findByCategoryId(category.getCategoryId());

        if(items.isEmpty()) throw new ItemException("Items not found");

        return items;

    }

    @Override
    public List<ItemsInRestaurantDTO> viewItemsByRestaurant(Integer restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(()-> new RestaurantException("Invalid restaurant id : "+restaurantId));

        List<ItemsInRestaurantDTO> items =  new ArrayList<>(); //itemRepository.getItemsInRestaurantById(restaurantId);

        if(items.isEmpty()) throw new ItemException("No Items found");

        return items;

    }

    public ItemsInRestaurantDTO getDtoFromItem(Item item){

        ItemsInRestaurantDTO itemDTO = new ItemsInRestaurantDTO();

        itemDTO.setItemId(item.getItemId());

        itemDTO.setItemName(item.getItemName());

        itemDTO.setCost(item.getCost());

        Category category = validateCategory(item.getCategoryId());

        itemDTO.setCategory(category);

//        itemDTO.setRestaurant();

        return itemDTO;

    }

    private Category validateCategory(Integer categoryId){

        Category category = restTemplate.getForObject("http://CATEGORY-SERVICE/fooddelivery/category"+categoryId, Category.class);

        if(category==null) throw new RuntimeException("Category does not exists with id : "+categoryId);

        return category;

    }
}
