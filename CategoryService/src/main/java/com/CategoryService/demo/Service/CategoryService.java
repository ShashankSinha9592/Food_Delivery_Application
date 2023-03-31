package com.CategoryService.demo.Service;

import com.CategoryService.demo.Model.Category;

import java.util.List;

public interface CategoryService {

    public Category addCategory(Category category);

    public Category updateCategory(Category category);

    public Category removeCategory(Integer categoryId);

    public Category viewCategory(Integer categoryId);

    public List<Category> viewAllCategory();

}
