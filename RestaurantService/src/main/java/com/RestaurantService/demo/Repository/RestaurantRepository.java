package com.RestaurantService.demo.Repository;

import com.RestaurantService.demo.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
