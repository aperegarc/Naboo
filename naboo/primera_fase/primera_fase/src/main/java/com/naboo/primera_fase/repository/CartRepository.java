package com.naboo.primera_fase.repository;

import com.naboo.primera_fase.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(int userId);
}