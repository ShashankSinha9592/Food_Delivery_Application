package com.OrderDetails.demo.Service;

import com.OrderDetails.demo.DTO.OrderDetailsDTO;
import com.OrderDetails.demo.Model.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    public OrderDetails addOrder(Integer cartId);

    public OrderDetails updateOrder(OrderDetails orderDetails);

    public OrderDetails removeOrder(Integer orderId);

    public OrderDetailsDTO viewOrder(Integer orderId);

    public List<OrderDetails> viewOrderOfRestaurant(Integer restaurantId);

    public List<OrderDetailsDTO> viewOrderOfCustomer(Integer userId);


}
