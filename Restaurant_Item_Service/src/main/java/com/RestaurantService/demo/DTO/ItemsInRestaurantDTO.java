package com.RestaurantService.demo.DTO;


import com.RestaurantService.demo.Model.Category;
import com.RestaurantService.demo.Model.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embedded;
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
public class ItemsInRestaurantDTO {

    private Integer itemId;

    private String itemName;

    private Category category;

    private Double cost;

    private Restaurant restaurant;

//    @Id
//    private Integer itemId;
//
//    private String itemName;
//
//    @Embedded
//    private Category category;
//
//    private Integer quantity;
//
//    private Double cost;
//
//    private Restaurant restaurant;
//
//    @ManyToMany
//    @JsonIgnore
//    private List<FoodCart> foodCarts = new ArrayList<>();
}
