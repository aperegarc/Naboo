package com.naboo.primera_fase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.naboo.primera_fase.entity.Order;
import com.naboo.primera_fase.repository.OrderRepository;

public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Integer id, Order newOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatOrder'");
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
    
    
}
