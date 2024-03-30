package com.example.SpringbootDemo.controller;

import com.example.SpringbootDemo.model.Product;
import com.example.SpringbootDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
    }


     //Read product by id
    @GetMapping("/{id}")
    public Product getProductDetails(@PathVariable("id") int id){
        return productService.getProduct(id);
    }


     //Read all products(commented for trying pagination code)
//    @GetMapping()
//    public List<Product> getAllProductDetails() {
//        return productService.GetAllProducts();
//    }
     @GetMapping()
     public Page<Product> getAllProductDetails(@RequestParam(defaultValue = "1") int page,
                                               @RequestParam(defaultValue = "10") int size) {
         Pageable pageable = PageRequest.of(page-1, size, Sort.by("pid"));
         return productService.getAllProductsWithPagination(pageable);
     }


    @PostMapping
    public String createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return "Product inserted successfully";
    }


    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        // Get the product by ID
        Product existingProduct = productService.getProduct(id);

        // Check if the product exists
        if (existingProduct != null) {
            // Update product details
            existingProduct.setPname(product.getPname());
            existingProduct.setPprice(product.getPprice());
            existingProduct.setPdesc(product.getPdesc());
            existingProduct.setCategory(product.getCategory());

            // Save the updated product
            productService.saveProduct(existingProduct);

            return "Product updated successfully";
        } else {
            // Return an appropriate response when the product is not found
            return "Product not found";
        }
    }

    // Delete by id
    @DeleteMapping("/{id}")
    public String DeleteProductDetails(@PathVariable("id") int id) {
        productService.DeleteProduct(id);
        return "Product deleted successfully!!";
    }

}
