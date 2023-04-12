package com.OrderDetails.demo.Exceptions;

public class OrderException extends RuntimeException{
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }
}
