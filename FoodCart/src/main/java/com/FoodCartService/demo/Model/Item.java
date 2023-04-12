package com.FoodCartService.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
@Entity
public class Item {
    @Id
    private Integer itemId;

    private String itemName;

    @Embedded
    private Category category;

    private Integer quantity;

    private Double cost;

    private Integer restaurantId ;

    @ManyToMany
    @JsonIgnore
    private List<FoodCart> foodCarts = new ArrayList<>();

}
