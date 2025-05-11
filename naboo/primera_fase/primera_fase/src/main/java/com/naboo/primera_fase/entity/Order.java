package com.naboo.primera_fase.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Data
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User hostelero;

    @ManyToOne
    private Product product;

    private Integer quantity;

    public enum OrderStatus {
        PENDING,
        COMPLETED,
        CANCELLED
    }

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Date fecha_pedido;

    private Date fecha_entrega;



}
