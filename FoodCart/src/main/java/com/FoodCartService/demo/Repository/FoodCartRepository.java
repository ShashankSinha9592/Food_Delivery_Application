package com.FoodCartService.demo.Repository;

import com.FoodCartService.demo.Model.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodCartRepository extends JpaRepository<FoodCart,Integer> {

    public Optional<FoodCart> findByUserId(Integer userId);

}
