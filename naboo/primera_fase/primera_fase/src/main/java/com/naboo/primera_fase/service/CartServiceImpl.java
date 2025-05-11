package com.naboo.primera_fase.service;

import com.naboo.primera_fase.entity.*;
import com.naboo.primera_fase.repository.CartRepository;
import com.naboo.primera_fase.repository.ProductRepository;
import com.naboo.primera_fase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Cart getCartByUserId(int userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart addItemToCart(int userId, int productId, int quantity) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty() || user.get().getRole() != UserRole.HOSTELERO) {
            throw new RuntimeException("El usuario no es un hostelero o no existe.");
        }

        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user.get());
        }

        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new RuntimeException("Producto no encontrado.");
        }

        CartItem item = new CartItem();
        item.setProduct(product.get());
        item.setQuantity(quantity);

        cart.addItem(item);
        return cartRepository.save(cart);
    }

}