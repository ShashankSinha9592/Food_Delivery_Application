package com.RestaurantService.demo.Controller;

import com.RestaurantService.demo.DTO.ItemsInRestaurantDTO;
import com.RestaurantService.demo.Model.Item;
import com.RestaurantService.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooddelivery/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemsInRestaurantDTO> addItem(@RequestBody Item item){

        ItemsInRestaurantDTO addedItem = itemService.addItem(item);

        return new ResponseEntity<>(addedItem, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<ItemsInRestaurantDTO> updateItem(@RequestBody Item item){

        ItemsInRestaurantDTO updatedItem = itemService.updateItem(item);

        return new ResponseEntity<>(updatedItem,HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Boolean> removeItem(@PathVariable Integer itemId){

        boolean removedItem = itemService.removeItem(itemId);

        return new ResponseEntity<>(removedItem,HttpStatus.OK);

    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemsInRestaurantDTO> viewItemById(Integer itemId){

        ItemsInRestaurantDTO item = itemService.viewItem(itemId);

        return new ResponseEntity<>(item,HttpStatus.OK);

    }

    @GetMapping("/itembycategory/{categoryName}")
    public ResponseEntity<List<Item>> viewItemByCategoryName(String categoryName){

        List<Item> items = itemService.viewItemsByCategory(categoryName);

        return new ResponseEntity<>(items,HttpStatus.OK);

    }

    @GetMapping("/itembyrestaurant/{restaurantId}")
    public ResponseEntity<List<ItemsInRestaurantDTO>> viewItemByRestaurant(Integer restaurantId){

        List<ItemsInRestaurantDTO> items = itemService.viewItemsByRestaurant(restaurantId);

        return new ResponseEntity<>(items,HttpStatus.OK);

    }


}
