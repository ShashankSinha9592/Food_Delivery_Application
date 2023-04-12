package com.OrderDetails.demo.Service;

import com.OrderDetails.demo.Model.OrderDetails;
import com.OrderDetails.demo.Repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderDetailsServiceImpl implements OrderDetailsService{

    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Override
    public OrderDetails addOrder(OrderDetails orderDetails) {

        return orderDetailsRepository.save(orderDetails);

    }

    @Override
    public OrderDetails updateOrder(OrderDetails orderDetails, Integer restaurantId) {



    }

    @Override
    public OrderDetails removeOrder(Integer orderId) {
        return null;
    }

    @Override
    public OrderDetails viewOrder(Integer orderId) {
        return null;
    }

    @Override
    public List<OrderDetails> viewOrderOfRestaurant(Integer restaurantId) {
        return null;
    }

    @Override
    public List<OrderDetails> viewOrderOfCustomer(Integer userId) {
        return null;
    }
}
