package com.danilo_alves.simplified_erp.presentation.dto.user;

import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import com.danilo_alves.simplified_erp.domain.entity.user.enums.RoleDomain;

import java.util.List;
import java.util.stream.Collectors;

public record UserResponseDTO(
        String id,
        String name,
        String username,
        RoleDomain role
) {

    public static UserResponseDTO fromDomain(UserDomain domain) {
        return new UserResponseDTO(
                domain.getId(),
                domain.getName(),
                domain.getUsername(),
                domain.getRoleDomain()
        );
    }

    public static List<UserResponseDTO> fromDomain(List<UserDomain> domains) {
        return domains.stream()
                .map(UserResponseDTO::fromDomain)
                .collect(Collectors.toList());
    }
}
