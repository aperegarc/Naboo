package com.naboo.primera_fase.repository;

import com.naboo.primera_fase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
