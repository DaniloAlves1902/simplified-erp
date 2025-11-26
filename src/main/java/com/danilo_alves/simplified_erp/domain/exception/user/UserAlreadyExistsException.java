package com.danilo_alves.simplified_erp.domain.exception.user;

public class UserAlreadyExistsException extends RuntimeException {
  public UserAlreadyExistsException(String username) {
    super("User with username: " + username + " already exists.");
  }
}
