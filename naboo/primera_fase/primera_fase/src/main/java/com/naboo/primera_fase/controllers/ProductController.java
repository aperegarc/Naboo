package com.naboo.primera_fase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naboo.primera_fase.entity.Product;
import com.naboo.primera_fase.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> listProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        for (Product product : productService.getAllProducts()) {
            if(product.getId() == id){
                return product;
            }
        }
        System.out.println("No se haencontrado el d del producto");
        return null;
    }
    
    


}
