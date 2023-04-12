package com.FoodDeliveryApp.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
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
public class Address {

    private Integer addressId;

    private String buildingName;

    private String streetName;

    private String area;

    private String city;

    private String state;

    private String country;

    private Integer pinCode;

//    @JsonIgnore
//    @Transient
//    private Restaurant restaurant;
//
//    @JsonIgnore
//    @Transient
//    private User user;

}
