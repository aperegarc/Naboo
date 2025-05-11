package com.naboo.primera_fase.repository;

import com.naboo.primera_fase.entity.Order;
import com.naboo.primera_fase.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    public Optional<Order> findById(Integer id);
}
