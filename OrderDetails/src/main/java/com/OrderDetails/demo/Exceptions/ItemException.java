package com.OrderDetails.demo.Exceptions;

public class ItemException extends RuntimeException{
    public ItemException() {
    }

    public ItemException(String message) {
        super(message);
    }
}
