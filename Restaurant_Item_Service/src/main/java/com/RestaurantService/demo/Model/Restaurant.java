package com.RestaurantService.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;

    private String restaurantName;

    @JsonIgnore
    private Integer addressId;

    private String managerName;

    private String contact;

    @ManyToMany(mappedBy = "restaurants")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Item> items = new ArrayList<>();

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", addressId=" + addressId +
                ", managerName='" + managerName + '\'' +
                ", contact='" + contact + '\'' +
                ", items=" + items +
                '}';
    }
}
