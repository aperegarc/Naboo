package com.naboo.primera_fase.controllers;

import com.naboo.primera_fase.entity.Order;
import com.naboo.primera_fase.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {
    
    @Autowired
    OrderService orderService;

    @GetMapping
    public List<Order> listOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        for (Order order : orderService.getAllOrders()) {
            if(order.getId() == id){
                return order;
            }
        }
        System.out.println("No se ha encontrado el id del ordero");
        return null;
    }

    @PostMapping
    public ResponseEntity<?> postOrder(@RequestBody Order newOrder) {
        orderService.saveOrder(newOrder);
        return ResponseEntity.ok(newOrder);
    }

    @PutMapping("/{id}")
    public Order putOrder(@PathVariable Integer id, @RequestBody Order newOrder){
        return orderService.updateOrder(id, newOrder);
    }

    // @DeleteMapping("/{id}")
    public List<Order> deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return orderService.getAllOrders();
    }


}
