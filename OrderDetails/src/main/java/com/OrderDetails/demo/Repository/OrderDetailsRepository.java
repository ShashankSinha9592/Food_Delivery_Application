package com.OrderDetails.demo.Repository;

import com.OrderDetails.demo.Model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {
}
