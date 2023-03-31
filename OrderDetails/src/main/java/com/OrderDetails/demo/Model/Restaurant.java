package com.OrderDetails.demo.Model;

import jakarta.persistence.Entity;
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

    private Integer restaurantId;

    private String restaurantName;

    private Address address;

//    private List<Item> items = new ArrayList<>();

    private String managerName;

    private String contact;
}
