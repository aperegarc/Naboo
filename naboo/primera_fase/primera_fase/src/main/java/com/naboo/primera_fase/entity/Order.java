package com.naboo.primera_fase.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "naboo_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId; // Asociar el pedido al ID del usuario

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> items; // Ítems del pedido

    private Double totalAmount; // Monto total del pedido

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}