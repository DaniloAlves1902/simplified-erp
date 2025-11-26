package com.danilo_alves.simplified_erp.domain.entity.user;

import com.danilo_alves.simplified_erp.domain.entity.user.enums.RoleDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {
    private String id;
    private String name;
    private String username;
    private String password;
    private RoleDomain roleDomain;
}