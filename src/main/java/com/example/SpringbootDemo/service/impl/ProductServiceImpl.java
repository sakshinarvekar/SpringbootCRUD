package com.example.SpringbootDemo.service.impl;

import java.util.List;
import com.example.SpringbootDemo.model.Product;
import com.example.SpringbootDemo.repository.ProductRepo;
import com.example.SpringbootDemo.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }


    @Override
    public String DeleteProduct(int id) {
        productRepo.deleteById(id);
        return "Success delete";
    }

    @Override
    public Product getProduct(int id) {

        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> GetAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Page<Product> getAllProductsWithPagination(Pageable pageable) {
        return productRepo.findAll(pageable);
    }
}


