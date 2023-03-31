package com.FoodCartService.demo.Repository;

import com.FoodCartService.demo.Model.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCartRepository extends JpaRepository<FoodCart,Integer> {
}
