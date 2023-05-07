package com.OrderDetails.demo.DTO;

import com.OrderDetails.demo.Model.FoodCart;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDTO {

    private Integer orderId;

    private LocalDateTime timeSpan;

    private FoodCart foodCart;

    private String status;

}
