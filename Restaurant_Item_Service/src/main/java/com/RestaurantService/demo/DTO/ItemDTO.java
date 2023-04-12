package com.RestaurantService.demo.DTO;


import com.RestaurantService.demo.Model.Category;
import jakarta.persistence.Entity;
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

    private Integer itemId;

    private String itemName;

    private Category category;

    private Double cost;

    private List<RestaurantsInItemDTO> restaurants = new ArrayList<>();

}
