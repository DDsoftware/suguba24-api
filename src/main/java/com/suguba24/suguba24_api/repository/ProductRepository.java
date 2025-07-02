package com.suguba24.suguba24_api.repository;

import com.suguba24.suguba24_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
