package com.danilo_alves.simplified_erp.infrastructure.mapper.user;

import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import com.danilo_alves.simplified_erp.infrastructure.persistence.entity.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "roleEntity", target = "roleDomain")
    UserDomain toDomain(UserEntity userEntity);

    @Mapping(source = "roleDomain", target = "roleEntity")
    UserEntity toEntity(UserDomain userDomain);
}
