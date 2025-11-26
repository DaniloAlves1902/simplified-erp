package com.danilo_alves.simplified_erp.infrastructure.adapter.user;

import com.danilo_alves.simplified_erp.application.gateway.user.UserGateway;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import com.danilo_alves.simplified_erp.domain.exception.user.UserNotFoundException;
import com.danilo_alves.simplified_erp.infrastructure.mapper.user.UserMapper;
import com.danilo_alves.simplified_erp.infrastructure.persistence.repository.UserRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {
    private final UserRepositoryJPA userRepositoryJPA;
    private final UserMapper userMapper;

    @Override
    public UserDomain save(UserDomain user) {
        var entity = userMapper.toEntity(user);
        var saved = userRepositoryJPA.save(entity);
        return userMapper.toDomain(saved);
    }

    @Override
    public UserDomain update(UserDomain user) {
        userRepositoryJPA.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException(user.getId()));

        var entity = userMapper.toEntity(user);
        var updateEntity = userRepositoryJPA.save(entity);

        return userMapper.toDomain(updateEntity);
    }

    @Override
    public void delete(String id) {
        if (!userRepositoryJPA.existsById(id)) {
            throw new UserNotFoundException(id);
        }

        userRepositoryJPA.deleteById(id);
    }

    @Override
    public List<UserDomain> getAll() {
        return userRepositoryJPA.findAll().stream()
                .map(userMapper::toDomain)
                .toList();
    }

    @Override
    public UserDomain getById(String id) {
        return userRepositoryJPA.findById(id)
                .map(userMapper::toDomain)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepositoryJPA.existsByUsername(username);
    }

    @Override
    public Optional<UserDomain> findByUsername(String username) {
        return userRepositoryJPA.findByUsername(username)
                .map(userMapper::toDomain);
    }
}