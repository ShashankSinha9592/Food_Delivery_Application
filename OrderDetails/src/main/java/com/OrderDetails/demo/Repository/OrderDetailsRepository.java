package com.OrderDetails.demo.Repository;

import com.OrderDetails.demo.Model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {

    public List<OrderDetails> findByCartId(Integer cartId);


}
