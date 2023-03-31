package com.CategoryService.demo.Repository;

import com.CategoryService.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryInterface extends JpaRepository<Category, Integer> {
}
