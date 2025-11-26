package com.danilo_alves.simplified_erp.infrastructure.persistence.repository;

import com.danilo_alves.simplified_erp.infrastructure.persistence.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, String> {
    boolean existsByUsername (String username);
    Optional<UserEntity> findByUsername(String username);
}
