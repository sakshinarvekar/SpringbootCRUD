package com.example.SpringbootDemo.service;

import com.example.SpringbootDemo.model.Category;
import com.example.SpringbootDemo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    //public String UpdateProduct(Product product);
    public String DeleteProduct(int id);
    public Product getProduct(int id);
    public List<Product> GetAllProducts();

    //
    Page<Product> getAllProductsWithPagination(Pageable pageable);

}
