package com.BillService.demo.Service;

import com.BillService.demo.Model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderDetailService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public OrderDetails getOrderDetails(Integer orderId) {

        OrderDetails orderDetails = restTemplate.getForObject("https://ORDER-SERVICE/"+orderId, OrderDetails.class);

        return orderDetails;


    }
}
