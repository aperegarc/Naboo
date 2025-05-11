package com.naboo.primera_fase.service;

import java.util.List;

import com.naboo.primera_fase.entity.Product;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product saveProduct(Product product);
    public Product updateProduct(Integer id, Product newProduct);
    public void deleteProduct(Integer id);

}
