package com.FoodDeliveryApp.demo.DTO;

import com.FoodDeliveryApp.demo.Model.Item;
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
public class FoodCartDTO {

    private Integer cartId;

    private Integer userId;

    private List<Item> items = new ArrayList<>();

}
