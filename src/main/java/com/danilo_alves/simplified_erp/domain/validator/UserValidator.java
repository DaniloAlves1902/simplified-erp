package com.danilo_alves.simplified_erp.domain.validator;

import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;

public class UserValidator {
    public static void validate(UserDomain userDomain) {
        if (userDomain == null) {
            throw new IllegalArgumentException("UserDomain cannot be null");
        }

        if (userDomain.getName() == null || userDomain.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("UserDomain name is required");
        }

        if (userDomain.getUsername() == null || userDomain.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("UserDomain username is required");
        }

        String password = userDomain.getPassword();

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }

        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character.");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one number.");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        }
    }
}
