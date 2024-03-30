package com.example.SpringbootDemo.service.impl;

import com.example.SpringbootDemo.model.Category;
import com.example.SpringbootDemo.model.Product;
import com.example.SpringbootDemo.repository.CategoryRepo;
import com.example.SpringbootDemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo  categoryRepo;

    private CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public String CreateCategory(Category category) {
        categoryRepo.save(category);
        return "Success!";
    }


    @Override
    public void updateCategory(int id, Category updateCategory) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setCname(updateCategory.getCname()); // Update category's name
            categoryRepo.save(existingCategory);
        } else {
            throw new IllegalArgumentException("Category not found with id: " + id);
        }
    }

    @Override
    public String DeleteCategory(int id) {
        categoryRepo.deleteById(id);
        return "Success delete";
    }

    @Override
    public Optional<Category> getCategory(int id) {
         return categoryRepo.findById(id);

    }

    @Override
    public List<Category> GetAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Page<Category> getAllCategoriesWithPagination(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

}
