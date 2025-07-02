package com.suguba24.suguba24_api.controller;

import com.suguba24.suguba24_api.entity.Product;
import com.suguba24.suguba24_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductControler {

    @Autowired private ProductService productService;

    // Product endpoints
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) { return productService.addProduct(product); }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) { return productService.updateProduct(id, product); }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) { productService.deleteProduct(id); }

}
