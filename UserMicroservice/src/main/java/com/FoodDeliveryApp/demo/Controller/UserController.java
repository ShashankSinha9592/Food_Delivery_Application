package com.FoodDeliveryApp.demo.Controller;

import com.FoodDeliveryApp.demo.DTO.UserDTO;
import com.FoodDeliveryApp.demo.Model.FoodCart;
import com.FoodDeliveryApp.demo.Model.User;
import com.FoodDeliveryApp.demo.Service.UserService;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
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
    @CircuitBreaker(name = "AddressAndCartCircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){

        UserDTO registeredUserDTO = userService.registerUser(userDTO);

        return new ResponseEntity<>(registeredUserDTO, HttpStatus.CREATED);

    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "AddressCircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId){

        UserDTO userDTO = userService.viewUser(userId);

        return new ResponseEntity<>(userDTO,HttpStatus.OK);

    }

    @GetMapping
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> users = userService.viewAllUser();

        return new ResponseEntity<>(users,HttpStatus.OK);

    }

    @DeleteMapping("/{userId}")
    @CircuitBreaker(name = "AddressAndCartCircuitBreaker")
    @Retry(name = "RetryModule", fallbackMethod = "fallBackRetryHandler")
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<User> removeUser(@PathVariable Integer userId){

        User user = userService.removeUser(userId);

        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    public ResponseEntity<String> fallBackRetryHandler(FeignException exc){
        System.out.println(exc);
        return new ResponseEntity<>("All retries have been exhausted, please try again later", HttpStatus.SERVICE_UNAVAILABLE);
    }


    @PutMapping
    @RateLimiter(name = "RateLimiterHandler")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO){

        User updatedUser = userService.updateUser(userDTO);

        return new ResponseEntity<>(updatedUser,HttpStatus.ACCEPTED);

    }


}
