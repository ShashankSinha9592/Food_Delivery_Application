package com.FoodDeliveryApp.demo.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Transient
    private Address address;

    @Transient
    private FoodCart foodCart;


}
