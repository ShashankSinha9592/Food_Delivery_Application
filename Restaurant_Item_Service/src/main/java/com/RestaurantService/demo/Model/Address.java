package com.RestaurantService.demo.Model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

    private Integer addressId;

    private String buildingName;

    private String streetName;

    private String area;

    private String city;

    private String state;

    private String country;

    private Integer pinCode;

}
