package com.FoodCartService.demo.DTO;


import com.FoodCartService.demo.Model.Category;
import com.FoodCartService.demo.Model.FoodCart;
import com.FoodCartService.demo.Model.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class ItemDTO {

    private Integer cartItemId;

    private Integer itemId;

    private String itemName;

    private Category category;

    private Integer quantity;

    private Double cost;

    private Restaurant restaurant;

    @JsonIgnore
    private FoodCart foodCart ;

}
