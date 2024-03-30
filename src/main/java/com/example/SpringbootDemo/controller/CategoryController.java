package com.example.SpringbootDemo.controller;

import com.example.SpringbootDemo.model.Category;
import com.example.SpringbootDemo.model.Product;
import com.example.SpringbootDemo.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Read category by id
    @GetMapping("/{id}")
    public Category getCategoryDetails(@PathVariable("id") int id){
        Optional <Category> optionalCategory = categoryService.getCategory(id);
        return optionalCategory.orElse(null);
    }

    // Read all categories(commented beacause added pagination)
//    @GetMapping()
//    public List<Category> getAllCategoryDetails(){
//        return categoryService.GetAllCategories();
//    }

    // Create category
    @PostMapping
    public String CreateCategoryDetails(@RequestBody Category category){
        categoryService.CreateCategory(category);
        return "Category created successfully!!";
    }

    // Update category
    @PutMapping("/{id}")
    public String UpdateCategoryDetails(@PathVariable int id, @RequestBody Category category){
        categoryService.updateCategory(id,category);
        return "Category updated successfully!!";
    }

    // Delete by category id
    @DeleteMapping("/{id}")
    public String DeleteCategoryDetails(@PathVariable("id") int id){
        categoryService.DeleteCategory(id);
        return "Category deleted successfully!!";
    }

    //get all categories with pagination
    @GetMapping
    public Page<Category> getAllCategoryDetails(@RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("cid"));
        return categoryService.getAllCategoriesWithPagination(pageable);
    }
}
