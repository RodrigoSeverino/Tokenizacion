package com.tokenizacion.enums;

public enum StatusEnum {
    ACTIVE(1), SUSPENDED(2), DELETED(3), PENDING(4);
    private int value;
    private StatusEnum (int value) {
        this.value = value;
    }
}