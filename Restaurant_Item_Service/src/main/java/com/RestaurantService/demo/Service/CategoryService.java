package com.RestaurantService.demo.Service;

import com.RestaurantService.demo.Model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CATEGORY-SERVICE")
public interface CategoryService {

    @GetMapping("/fooddelivery/category/{categoryId}")
    public Category getCategoryById(@PathVariable Integer categoryId);

    @GetMapping("/fooddelivery/category/name/{categoryName}")
    public Category getCategoryByName(@PathVariable String categoryName);


}
