package com.example.warehouse10b.repository;

import com.example.warehouse10b.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
