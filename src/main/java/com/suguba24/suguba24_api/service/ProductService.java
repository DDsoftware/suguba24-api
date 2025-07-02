package com.suguba24.suguba24_api.service;

import com.suguba24.suguba24_api.entity.Product;
import com.suguba24.suguba24_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepo;

    public Product addProduct(Product product) { return productRepo.save(product); }
    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepo.save(product);
    }
    public void deleteProduct(Long id) { productRepo.deleteById(id); }
}
