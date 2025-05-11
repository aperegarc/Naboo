package com.naboo.primera_fase.service;

import com.naboo.primera_fase.entity.Cart;
import com.naboo.primera_fase.entity.CartItem;
import com.naboo.primera_fase.entity.Product;
import com.naboo.primera_fase.entity.User;
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
        return cartRepository.findByUser_Id(userId);
    }

    public Cart addItemToCart(int userId, int productId, int quantity) {
        Cart cart = getCartByUserId(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(userRepository.findById(userId).get());
        }

        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        CartItem item = new CartItem();
        item.setProduct(product.get());
        item.setQuantity(quantity);

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }
}