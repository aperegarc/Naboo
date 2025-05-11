package com.naboo.primera_fase.controllers;

import com.naboo.primera_fase.entity.Cart;
import com.naboo.primera_fase.entity.User;
import com.naboo.primera_fase.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public Cart getCart(@RequestParam int userId) {
        return cartService.getCartByUser(new User(userId));
    }

    @PostMapping("/add")
    public Cart addItemToCart(@RequestParam int userId, @RequestParam int productId, @RequestParam int quantity) {
        return cartService.addItemToCart(new User(userId), productId, quantity);
    }
}