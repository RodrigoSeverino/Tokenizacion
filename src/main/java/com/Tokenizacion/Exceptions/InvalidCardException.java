package com.Tokenizacion.Exceptions;
public class InvalidCardException extends RuntimeException{
    public static String code = "400";
    private String message;
    public InvalidCardException(String message) {
        super();
        this.message = message;
    }
}