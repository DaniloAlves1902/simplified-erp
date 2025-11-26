package com.danilo_alves.simplified_erp.domain.exception.user;

public class UsernameNotFoundException extends RuntimeException {
    public UsernameNotFoundException(String username) {
        super("Username not found: " + username);
    }
}
