package com.OrderDetails.demo.Controller;

import com.OrderDetails.demo.DTO.OrderDetailsDTO;
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

    @PostMapping("/{cartId}")
    public ResponseEntity<OrderDetails> addOrder( @PathVariable Integer cartId){

        OrderDetails savedOrder = orderDetailsService.addOrder(cartId);

        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails orderDetails){

        OrderDetails updatedOrder = orderDetailsService.updateOrder(orderDetails);

        return new ResponseEntity<>(updatedOrder,HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderDetails> removeOrder(@PathVariable Integer orderId){

        OrderDetails removedOrder = orderDetailsService.removeOrder(orderId);

        return new ResponseEntity<>(removedOrder,HttpStatus.OK);

    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetailsDTO> viewOrder(@PathVariable Integer orderId){

        OrderDetailsDTO orderDetailsdto = orderDetailsService.viewOrder(orderId);

        return new ResponseEntity<>(orderDetailsdto,HttpStatus.OK);

    }

//    @GetMapping("/ordersofarestaurant/{restaurantId}")
//    public ResponseEntity<List<OrderDetails>> viewOrderOfRestaurant(Integer restaurantId){
//
//        List<OrderDetails> orderDetails = orderDetailsService.viewOrderOfRestaurant(restaurantId);
//
//        return new ResponseEntity<>(orderDetails,HttpStatus.OK);
//
//    }
    @GetMapping("/ordersofacustomer/{cartId}")
    public ResponseEntity<List<OrderDetailsDTO>> viewOrderOfCustomer(@PathVariable Integer cartId){

        List<OrderDetailsDTO> orderDetailsDTO = orderDetailsService.viewOrderOfCustomer(cartId);

        return new ResponseEntity<>(orderDetailsDTO,HttpStatus.OK);
    }

}
