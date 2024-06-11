package com.example.warehouse10b.repository;

import com.example.warehouse10b.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
