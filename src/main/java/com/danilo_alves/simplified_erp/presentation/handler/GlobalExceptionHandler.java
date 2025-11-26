package com.danilo_alves.simplified_erp.presentation.handler;

import com.danilo_alves.simplified_erp.domain.exception.product.ProductAlreadyExistsException;
import com.danilo_alves.simplified_erp.domain.exception.product.ProductNotFoundException;
import com.danilo_alves.simplified_erp.domain.exception.user.UserAlreadyExistsException;
import com.danilo_alves.simplified_erp.domain.exception.user.UserNotFoundException;
import com.danilo_alves.simplified_erp.domain.exception.user.UsernameNotFoundException;
import com.danilo_alves.simplified_erp.presentation.dto.error.ApiErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleProductNotFound(ProductNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiErrorDTO error = ApiErrorDTO.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .error("Resource Not Found")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleUserNotFound(UserNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiErrorDTO error = ApiErrorDTO.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .error("Resource Not Found")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public  ResponseEntity<ApiErrorDTO> handleProductAlreadyExists(ProductAlreadyExistsException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;

        ApiErrorDTO error = ApiErrorDTO.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .error("Resource Already Exists")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public  ResponseEntity<ApiErrorDTO> handleUserAlreadyExists(UserAlreadyExistsException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;

        ApiErrorDTO error = ApiErrorDTO.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .error("Resource Already Exists")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public  ResponseEntity<ApiErrorDTO> handleUsernameNotFound(UsernameNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiErrorDTO error = ApiErrorDTO.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .error("Resource Not Found")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorDTO> handleIllegalArgument(IllegalArgumentException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiErrorDTO error = ApiErrorDTO.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .error("Invalid Argument")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiErrorDTO> handleBadCredentials(BadCredentialsException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;

        ApiErrorDTO error = ApiErrorDTO.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .error("Authentication Failed")
                .message("Invalid credentials.")
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleGenericException(Exception e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        log.error("An unexpected error occurred at path: {}", request.getRequestURI(), e);

        ApiErrorDTO error = ApiErrorDTO.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .error("Internal Server Error")
                .message("An unexpected internal server error has occurred.")
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

}
