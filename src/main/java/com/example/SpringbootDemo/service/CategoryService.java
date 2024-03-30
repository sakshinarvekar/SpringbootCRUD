package com.example.SpringbootDemo.service;

import com.example.SpringbootDemo.model.Category;
import com.example.SpringbootDemo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public String CreateCategory(Category category);

    void updateCategory(int id, Category updateCategory);

    public String DeleteCategory(int id);
    public Optional<Category> getCategory(int id);
    public List<Category> GetAllCategories();
    //
    Page<Category> getAllCategoriesWithPagination(Pageable pageable);

}
