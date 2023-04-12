package com.FoodCartService.demo.Controller;


import com.FoodCartService.demo.DTO.FoodCartDTO;
import com.FoodCartService.demo.Model.FoodCart;
import com.FoodCartService.demo.Model.Item;
import com.FoodCartService.demo.Service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fooddelivery/foodcart")
public class FoodCartController {

    @Autowired
    FoodCartService foodCartService;

    @PostMapping
    public ResponseEntity<FoodCartDTO> registerCart(@RequestBody FoodCartDTO foodCartDTO){

        FoodCartDTO savedCartDTO = foodCartService.createCartForUser(foodCartDTO);

        return new ResponseEntity<>(savedCartDTO,HttpStatus.CREATED);

    }

    @PostMapping("/{foodCartId}/{restaurantId}/{itemId}")
    public ResponseEntity<FoodCart> addItemToCart(@PathVariable Integer foodCartId,@PathVariable Integer restaurantId, @PathVariable Integer itemId){

       FoodCart foodCart = foodCartService.addItemToCart(foodCartId,itemId,restaurantId);

       return new ResponseEntity<>(foodCart, HttpStatus.CREATED);

    }

    @PatchMapping("/{cartId}/{itemId}/{quantity}")
    public ResponseEntity<FoodCart> increaseOrReduceQuantityOfItem(@PathVariable Integer cartId, @PathVariable Integer itemId, @PathVariable Integer quantity){

        FoodCart foodCart = foodCartService.increaseOrReduceQuantityOfItem(cartId,itemId,quantity);

        return new ResponseEntity<>(foodCart,HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{cartId}/{itemId}")
    public ResponseEntity<FoodCart> removeItemFromCart(@PathVariable Integer cartId, @PathVariable Integer itemId){

        FoodCart foodCart = foodCartService.removeItemFromCart(cartId,itemId);

        return new ResponseEntity<>(foodCart,HttpStatus.OK);

    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<FoodCart> clearCart(@PathVariable Integer cartId){

        FoodCart foodCart = foodCartService.clearCart(cartId);

        return new ResponseEntity<>(foodCart,HttpStatus.OK);

    }

}
