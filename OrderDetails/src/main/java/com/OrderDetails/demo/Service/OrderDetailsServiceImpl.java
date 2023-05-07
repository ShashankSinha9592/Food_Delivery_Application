package com.OrderDetails.demo.Service;

import com.OrderDetails.demo.DTO.OrderDetailsDTO;
import com.OrderDetails.demo.Exceptions.OrderException;
import com.OrderDetails.demo.Model.FoodCart;
import com.OrderDetails.demo.Model.OrderDetails;
import com.OrderDetails.demo.Repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    CartService cartService;

    @Override
    public OrderDetails addOrder(Integer cartId) {

        validateCart(cartId);

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setCartId(cartId);

        orderDetails.setStatus("Pending");

        orderDetails.setTimeSpan(LocalDateTime.now());

        return orderDetailsRepository.save(orderDetails);

    }

    @Override
    public OrderDetails updateOrder(OrderDetails orderDetails) {

        validateCart(orderDetails.getCartId());

        return orderDetailsRepository.save(orderDetails);


    }

    @Override
    public OrderDetails removeOrder(Integer orderId) {

        OrderDetails orderDetails = validateOrderDetails(orderId);

        orderDetailsRepository.delete(orderDetails);

        return orderDetails;

    }

    @Override
    public OrderDetailsDTO viewOrder(Integer orderId) {

        OrderDetails orderDetails = validateOrderDetails(orderId);

        return getDTOFromOrder(orderDetails);

    }

    @Override
    public List<OrderDetails> viewOrderOfRestaurant(Integer restaurantId) { return  null; }

    @Override
    public List<OrderDetailsDTO> viewOrderOfCustomer(Integer cartId) {

        List<OrderDetails> orderDetails = orderDetailsRepository.findByCartId(cartId);

        if(orderDetails.isEmpty()) throw new OrderException("No orders found");

        List<OrderDetailsDTO> orderDetailsDTOS = new ArrayList<>();

        orderDetails.stream().forEach((el) -> orderDetailsDTOS.add(getDTOFromOrder(el)));

        return orderDetailsDTOS;

    }

    private FoodCart validateCart(Integer cartId){

        FoodCart foodCart = cartService.getCart(cartId);

        if(foodCart==null) throw new RuntimeException("Food Cart does not exists");

        return foodCart;

    }

    private OrderDetails validateOrderDetails(Integer orderId){

        return orderDetailsRepository.findById(orderId).orElseThrow(()-> new OrderException("Invalid order id : "+orderId));

    }

    private OrderDetailsDTO getDTOFromOrder(OrderDetails orderDetails){

        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        FoodCart foodCart = validateCart(orderDetails.getCartId());

        orderDetailsDTO.setFoodCart(foodCart);

        orderDetailsDTO.setStatus(orderDetails.getStatus());

        orderDetailsDTO.setOrderId(orderDetails.getOrderId());

        orderDetailsDTO.setTimeSpan(orderDetails.getTimeSpan());

        return orderDetailsDTO;

    }
}
