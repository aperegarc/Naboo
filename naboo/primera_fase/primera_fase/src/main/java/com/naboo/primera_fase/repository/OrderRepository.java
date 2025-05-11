package com.naboo.primera_fase.repository;

import com.naboo.primera_fase.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
