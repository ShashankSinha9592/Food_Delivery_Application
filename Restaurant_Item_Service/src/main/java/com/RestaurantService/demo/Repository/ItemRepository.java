package com.RestaurantService.demo.Repository;

import com.RestaurantService.demo.DTO.ItemsInRestaurantDTO;
import com.RestaurantService.demo.Model.Item;
import com.RestaurantService.demo.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    public List<Item> findByCategoryId(Integer categoryId);

    @Query("SELECT new ItemsInRestaurantDTO(item.itemId , item.itemName, item.cost) from Item item INNER JOIN item.restaurants restaurant where restaurant.restaurantId = :restaurantId")
    public List<ItemsInRestaurantDTO> getItemsInRestaurantById(@Param("restaurantId") Integer restaurantId);

}
