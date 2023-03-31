package com.BillService.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodCart {

    private Integer cartId;

    private Integer userId;

    private List<OrderDetails> orderDetails = new ArrayList<>();

}
