package com.RestaurantService.demo.Controller;

import com.RestaurantService.demo.DTO.ItemDTO;
import com.RestaurantService.demo.DTO.ItemsInRestaurantDTO;
import com.RestaurantService.demo.Model.Item;
import com.RestaurantService.demo.Service.ItemService;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
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
    @CircuitBreaker(name="CircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<ItemsInRestaurantDTO> addItem(@RequestBody ItemDTO item){

        ItemsInRestaurantDTO addedItem = itemService.addItem(item);

        return new ResponseEntity<>(addedItem, HttpStatus.CREATED);

    }

    @PutMapping
    @CircuitBreaker(name="CircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<ItemsInRestaurantDTO> updateItem(@RequestBody Item item){

        ItemsInRestaurantDTO updatedItem = itemService.updateItem(item);

        return new ResponseEntity<>(updatedItem,HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{itemId}")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<Boolean> removeItem(@PathVariable Integer itemId){

        boolean removedItem = itemService.removeItem(itemId);

        return new ResponseEntity<>(removedItem,HttpStatus.OK);

    }

    @GetMapping("/{itemId}")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<ItemsInRestaurantDTO> viewItemById(@PathVariable Integer itemId){

        ItemsInRestaurantDTO item = itemService.viewItem(itemId);

        return new ResponseEntity<>(item,HttpStatus.OK);

    }

    @GetMapping("/itembycategory/{categoryName}")
    @CircuitBreaker(name="CircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<List<Item>> viewItemByCategoryName(@PathVariable String categoryName){

        List<Item> items = itemService.viewItemsByCategory(categoryName);

        return new ResponseEntity<>(items,HttpStatus.OK);

    }

    @GetMapping("/itembyrestaurant/{restaurantId}")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<List<ItemsInRestaurantDTO>> viewItemByRestaurant(@PathVariable Integer restaurantId){

        List<ItemsInRestaurantDTO> items = itemService.viewItemsByRestaurant(restaurantId);

        return new ResponseEntity<>(items,HttpStatus.OK);

    }
    public ResponseEntity<String> fallBackRetryHandler(FeignException exc){
        System.out.println(exc);
        return new ResponseEntity<>("All retries have been exhausted, please try again later", HttpStatus.SERVICE_UNAVAILABLE);
    }


}
