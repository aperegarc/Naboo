package com.naboo.primera_fase.service;

import com.naboo.primera_fase.entity.Cart;
import com.naboo.primera_fase.entity.User;

public interface CartService {

    Cart getCartByUserId(int userId);
    Cart addItemToCart(int userId, int productId, int quantity);

}
