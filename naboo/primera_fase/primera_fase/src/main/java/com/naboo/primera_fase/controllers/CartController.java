package com.naboo.primera_fase.controllers;

import com.naboo.primera_fase.entity.Cart;
import com.naboo.primera_fase.entity.User;
import com.naboo.primera_fase.service.CartService;
import com.naboo.primera_fase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable int userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/add")
    public Cart addItemToCart(@RequestParam int userId, @RequestParam int productId, @RequestParam int quantity) {
        return cartService.addItemToCart(userId, productId, quantity);
    }
}