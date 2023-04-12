package com.AddressService.demo.Exceptions;

public class AddressException extends RuntimeException{
    public AddressException() {
    }

    public AddressException(String message) {
        super(message);
    }
}
