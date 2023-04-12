package com.FoodCartService.demo.Model;

import com.FoodCartService.demo.DTO.ItemDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Restaurant {

    private Integer restaurantId;

    private String restaurantName;

    private Address address;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ItemDTO> items = new ArrayList<>();

    private String managerName;

    private String contact;
}
