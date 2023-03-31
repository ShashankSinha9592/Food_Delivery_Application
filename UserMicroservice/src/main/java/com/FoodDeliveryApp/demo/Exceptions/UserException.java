package com.FoodDeliveryApp.demo.Exceptions;

public class UserException extends RuntimeException{
    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }
}
