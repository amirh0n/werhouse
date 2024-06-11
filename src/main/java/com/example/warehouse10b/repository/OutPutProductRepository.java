package com.example.warehouse10b.repository;

import com.example.warehouse10b.model.OutPut;
import com.example.warehouse10b.model.OutputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutPutProductRepository extends JpaRepository<OutputProduct,Integer> {
}
