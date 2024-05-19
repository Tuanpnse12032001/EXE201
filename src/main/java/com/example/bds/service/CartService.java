package com.example.bds.service;

import com.example.bds.Request.CartRequest.AddToCartRequest;
import com.example.bds.Response.CartResponse.CartResponse;
import com.example.bds.model.Cart;

import java.util.List;

public interface CartService {
    public CartResponse addToCart(AddToCartRequest request);

    public CartResponse removeCart(int cartId);

    List<Cart> viewCartByUserId(int userId);
}
