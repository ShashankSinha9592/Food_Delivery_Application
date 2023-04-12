package com.FoodCartService.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class FoodCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @Column(unique = true, nullable = false)
    @JsonIgnore
    private Integer userId;

    @ManyToMany(mappedBy = "foodCart", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

}
