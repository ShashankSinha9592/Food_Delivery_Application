package com.RestaurantService.demo.DTO;

import com.RestaurantService.demo.Model.Address;
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
public class RestaurantDTO {

    private Integer restaurantId;

    private String restaurantName;

    @Embedded
    private Address address;

    private List<ItemsInRestaurantDTO> items = new ArrayList<>();

    private String managerName;

    private String contact;
}
