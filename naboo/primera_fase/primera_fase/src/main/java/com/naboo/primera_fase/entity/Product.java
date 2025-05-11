package com.naboo.primera_fase.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private Double price;
    private int stock;

    @ManyToOne
    private User provider;
}
