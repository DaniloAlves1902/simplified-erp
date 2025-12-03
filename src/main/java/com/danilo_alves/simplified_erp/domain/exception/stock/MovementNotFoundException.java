package com.danilo_alves.simplified_erp.domain.exception.stock;

public class MovementNotFoundException extends RuntimeException {
    public MovementNotFoundException(String id) {
        super("Movement not found: " + id);
    }
}
