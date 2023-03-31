package com.RestaurantService.demo.Model;

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
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;

    private String restaurantName;

    @Embedded
    private Address address;

    @Transient
    private List<Item> items = new ArrayList<>();

    private String managerName;

    private String contact;
}
