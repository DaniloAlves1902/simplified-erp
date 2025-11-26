package com.danilo_alves.simplified_erp.application.gateway.user;

import com.danilo_alves.simplified_erp.application.gateway.Gateway;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;

import java.util.Optional;

public interface UserGateway extends Gateway<UserDomain, String> {
    boolean existsByUsername (String username);
    Optional<UserDomain> findByUsername(String username);
}
