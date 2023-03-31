package com.FoodCartService.demo.Exceptions;

public class CartException extends RuntimeException{
    public CartException() {
    }

    public CartException(String message) {
        super(message);
    }
}
