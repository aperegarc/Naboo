package com.naboo.primera_fase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.naboo.primera_fase.entity.Product;
import com.naboo.primera_fase.service.ProductService;


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
        System.out.println("No se ha encontrado el id del producto");
        return null;
    }

    @PostMapping
    public ResponseEntity<?> postProduct(@RequestBody Product newProduct) {
        productService.saveProduct(newProduct);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/{id}")
    public Product putProduct(@PathVariable Integer id, @RequestBody Product newProduct){
        return productService.updateProduct(id, newProduct);
    }

    // @DeleteMapping("/{id}")
    public List<Product> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return productService.getAllProducts();
    }
    


}
