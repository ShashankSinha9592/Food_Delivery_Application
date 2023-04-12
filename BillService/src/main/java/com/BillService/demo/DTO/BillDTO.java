package com.BillService.demo.DTO;

import com.BillService.demo.Model.OrderDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {

    private Integer billId;

    private LocalDateTime timeSpan;

    private OrderDetails orderDetails;

    private Integer totalItem;

    private Double totalCost;
}
