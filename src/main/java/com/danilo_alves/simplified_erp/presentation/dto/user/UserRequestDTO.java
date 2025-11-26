package com.danilo_alves.simplified_erp.presentation.dto.user;

import com.danilo_alves.simplified_erp.domain.entity.user.enums.RoleDomain;

public record UserRequestDTO(
        String id,
        String name,
        String username,
        String password,
        RoleDomain role
) {
}
