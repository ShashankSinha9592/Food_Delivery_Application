package com.CategoryService.demo.Repository;

import com.CategoryService.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public Optional<Category> findByCategoryName(String name);

}
