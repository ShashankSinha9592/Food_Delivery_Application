package com.ItemService.demo.Repository;

import com.ItemService.demo.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
