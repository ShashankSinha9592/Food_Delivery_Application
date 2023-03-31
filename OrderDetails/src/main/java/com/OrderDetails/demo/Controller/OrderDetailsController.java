package com.OrderDetails.demo.Controller;

import com.OrderDetails.demo.Model.OrderDetails;
import com.OrderDetails.demo.Service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooddelivery/orderdetails")
public class OrderDetailsController {

    @Autowired
    OrderDetailsService orderDetailsService;

    @PostMapping("/{restaurantid}")
    public ResponseEntity<OrderDetails> addOrder(OrderDetails orderDetails, Integer restaurantid){

        OrderDetails savedOrder = orderDetailsService.addOrder(orderDetails,restaurantid);

        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);

    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<OrderDetails> updateOrder(OrderDetails orderDetails, Integer restaurantId){

        OrderDetails updatedOrder = orderDetailsService.updateOrder(orderDetails,restaurantId);

        return new ResponseEntity<>(updatedOrder,HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderDetails> removeOrder(Integer orderId){

        OrderDetails removedOrder = orderDetailsService.removeOrder(orderId);

        return new ResponseEntity<>(removedOrder,HttpStatus.OK);

    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetails> viewOrder(Integer orderId){

        OrderDetails orderDetails = orderDetailsService.viewOrder(orderId);

        return new ResponseEntity<>(orderDetails,HttpStatus.OK);

    }

    @GetMapping("/ordersofarestaurant/{restaurantId}")
    public ResponseEntity<List<OrderDetails>> viewOrderOfRestaurant(Integer restaurantId){

        List<OrderDetails> orderDetails = orderDetailsService.viewOrderOfRestaurant(restaurantId);

        return new ResponseEntity<>(orderDetails,HttpStatus.OK);

    }
    @GetMapping("/ordersofacustomer/{userId}")
    public ResponseEntity<List<OrderDetails>> viewOrderOfCustomer(Integer userId){

        List<OrderDetails> orderDetails = orderDetailsService.viewOrderOfCustomer(userId);

        return new ResponseEntity<>(orderDetails,HttpStatus.OK);
    }

}
