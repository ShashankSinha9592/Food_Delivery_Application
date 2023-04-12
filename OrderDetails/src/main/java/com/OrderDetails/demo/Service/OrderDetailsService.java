package com.OrderDetails.demo.Service;

import com.OrderDetails.demo.Model.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    public OrderDetails addOrder(OrderDetails orderDetails);

    public OrderDetails updateOrder(OrderDetails orderDetails, Integer restaurantId);

    public OrderDetails removeOrder(Integer orderId);

    public OrderDetails viewOrder(Integer orderId);

    public List<OrderDetails> viewOrderOfRestaurant(Integer restaurantId);

    public List<OrderDetails> viewOrderOfCustomer(Integer userId);


}
