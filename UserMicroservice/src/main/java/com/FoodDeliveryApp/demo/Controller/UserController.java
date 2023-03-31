package com.FoodDeliveryApp.demo.Controller;

import com.FoodDeliveryApp.demo.Model.FoodCart;
import com.FoodDeliveryApp.demo.Model.User;
import com.FoodDeliveryApp.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooddelivery/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user){

        FoodCart foodCart = new FoodCart();

        user.setFoodCart(foodCart);

        User registeredUser = userService.registerUser(user);

        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId){

        User user = userService.viewUser(userId);

        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> users = userService.viewAllUser();

        return new ResponseEntity<>(users,HttpStatus.OK);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> removeUser(Integer userId){

        User user = userService.removeUser(userId);

        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){

        User updatedUser = userService.updateUser(user);

        return new ResponseEntity<>(updatedUser,HttpStatus.ACCEPTED);

    }


}
