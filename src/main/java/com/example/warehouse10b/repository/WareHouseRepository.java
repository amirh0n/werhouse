package com.example.warehouse10b.repository;

import com.example.warehouse10b.model.Product;
import com.example.warehouse10b.model.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WareHouseRepository extends JpaRepository<WareHouse,Integer> {
}
