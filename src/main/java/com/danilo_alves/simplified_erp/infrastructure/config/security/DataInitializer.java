package com.danilo_alves.simplified_erp.infrastructure.config.security;

import com.danilo_alves.simplified_erp.infrastructure.persistence.entity.user.UserEntity;
import com.danilo_alves.simplified_erp.infrastructure.persistence.entity.user.enums.RoleEntity;
import com.danilo_alves.simplified_erp.infrastructure.persistence.repository.UserRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final UserRepositoryJPA userRepositoryJPA;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (!userRepositoryJPA.existsByUsername("admin")){
            log.info("No 'admin' user found. Creating standard user...");

            UserEntity standardAdminUser = new UserEntity();
            standardAdminUser.setName("Standard User");
            standardAdminUser.setUsername("admin");
            standardAdminUser.setPassword(passwordEncoder.encode("Admin@123"));
            standardAdminUser.setRoleEntity(RoleEntity.ADMIN);

            userRepositoryJPA.save(standardAdminUser);

            log.info("Default Admin user created.");
        } else {
            log.info("The user 'admin' already exists. No action required.");
        }
    }
}
