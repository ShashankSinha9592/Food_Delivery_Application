package com.OrderDetails.demo.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetails {

    private Integer orderId;

    private LocalDateTime timeSpan;

    private List<Item> items = new ArrayList<>();

    private Integer cartId;

    private String status;

}
