package com.ItemService.demo.Model;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    private String itemName;

    @Embedded
    private Category category;

    private Integer quantity;

    private Double cost;

    @Transient
    private List<Restaurant> restaurants = new ArrayList<>();

}
