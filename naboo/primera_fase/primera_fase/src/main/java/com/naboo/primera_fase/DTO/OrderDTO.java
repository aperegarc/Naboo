package com.naboo.primera_fase.DTO;

import java.util.Date;

public class OrderDTO {

    private int id;
    private int hosteleroId; // ID del hostelero (relación con `User`)
    private int productId;   // ID del producto (relación con `Product`)
    private Integer quantity;
    private String status;   // Enum representado como String
    private Date fechaPedido;
    private Date fechaEntrega;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHosteleroId() {
        return hosteleroId;
    }

    public void setHosteleroId(int hosteleroId) {
        this.hosteleroId = hosteleroId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}