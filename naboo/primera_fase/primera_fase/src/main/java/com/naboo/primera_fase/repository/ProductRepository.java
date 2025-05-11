package com.naboo.primera_fase.repository;

import com.naboo.primera_fase.entity.Product;
import com.naboo.primera_fase.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    public Optional<Product> findById(Integer id);
}
