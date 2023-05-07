package com.RestaurantService.demo.Repository;

import com.RestaurantService.demo.DTO.RestaurantsInItemDTO;
import com.RestaurantService.demo.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {


//    @Query("SELECT new RestaurantsInItemDTO(r.restaurantId, r.restaurantName, r.managerName, r.contact) from Restaurant r INNER JOIN r.items i where i.itemId = :itemId")
//    public List<RestaurantsInItemDTO> getRestaurantsByItem(@Param("itemId") Integer itemId);

}
