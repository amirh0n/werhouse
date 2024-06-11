package com.example.warehouse10b.repository;

import com.example.warehouse10b.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
