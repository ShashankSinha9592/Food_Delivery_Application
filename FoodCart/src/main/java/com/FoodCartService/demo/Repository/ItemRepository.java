package com.FoodCartService.demo.Repository;

import com.FoodCartService.demo.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

//    @Query("DELETE item from Item item INNER JOIN item.foodCarts foodCart where item.itemId = :itemId and foodCart.cartId = :cartId" )
//    public void deleteItemFromCart(@Param("itemId") Integer itemId, @Param("cartId") Integer cartId);

//    @Query("DELETE item from Item item INNER JOIN item.foodCarts foodCart where foodCart.cartId = :cartId" )
//    public void clearCart(@Param("cartId") Integer cartId);

}
