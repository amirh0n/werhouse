package com.example.warehouse10b.repository;

import com.example.warehouse10b.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
}
