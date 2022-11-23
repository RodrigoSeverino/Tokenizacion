package com.Tokenizacion.Exceptions;
public class CardNotFoundException extends RuntimeException{
    public static String code = "404";
    private String message;
    public CardNotFoundException(String message) {
        super();
        this.message = message;
    }
}