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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getHostelero() {
        return hostelero;
    }

    public void setHostelero(User hostelero) {
        this.hostelero = hostelero;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
}
