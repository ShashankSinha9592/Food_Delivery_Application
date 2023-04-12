package com.RestaurantService.demo.DTO;

import com.RestaurantService.demo.Model.Address;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class RestaurantsInItemDTO {

    private Integer restaurantId;

    private String restaurantName;

    private Address address;

    private String managerName;

    private String contact;
}
