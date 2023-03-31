package com.ItemService.demo.Controller;

import com.ItemService.demo.Model.Item;
import com.ItemService.demo.Service.ItemService;
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
    public ResponseEntity<Item> addItem(@RequestBody Item item){

        Item addedItem = itemService.addItem(item);

        return new ResponseEntity<>(addedItem, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Item> updateItem(@RequestBody Item item){

        Item updatedItem = itemService.updateItem(item);

        return new ResponseEntity<>(updatedItem,HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Item> removeItem(@PathVariable Integer itemId){

        Item removedItem = itemService.removeItem(itemId);

        return new ResponseEntity<>(removedItem,HttpStatus.OK);

    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> viewItemById(Integer itemId){

        Item item = itemService.viewItem(itemId);

        return new ResponseEntity<>(item,HttpStatus.OK);

    }

    @GetMapping("/itembycategory/{categoryName}")
    public ResponseEntity<List<Item>> viewItemByCategoryName(String categoryName){

        List<Item> items = itemService.viewItemsByCategory(categoryName);

        return new ResponseEntity<>(items,HttpStatus.OK);

    }

    @GetMapping("/itembyrestaurant/{restaurantId}")
    public ResponseEntity<List<Item>> viewItemByRestaurant(Integer restaurantId){

        List<Item> items = itemService.viewItemsByRestaurant(restaurantId);

        return new ResponseEntity<>(items,HttpStatus.OK);

    }


}
