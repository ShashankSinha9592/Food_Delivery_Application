package com.FoodDeliveryApp.demo.DTO;

import com.FoodDeliveryApp.demo.Model.Address;
import com.FoodDeliveryApp.demo.Model.FoodCart;
import com.FoodDeliveryApp.demo.Model.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class UserDTO {

    private Integer userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private List<String> role = new ArrayList<>();

    private String mobile;

    private Address address;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private FoodCart foodCart;


}