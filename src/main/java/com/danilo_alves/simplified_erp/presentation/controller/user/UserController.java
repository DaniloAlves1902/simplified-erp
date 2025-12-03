package com.danilo_alves.simplified_erp.presentation.controller.user;

import com.danilo_alves.simplified_erp.application.usecase.user.*;
import com.danilo_alves.simplified_erp.domain.entity.user.UserDomain;
import com.danilo_alves.simplified_erp.presentation.dto.user.UserRequestDTO;
import com.danilo_alves.simplified_erp.presentation.dto.user.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    private final CreateUser createUser;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;
    private final GetAllUser getAllUsers;
    private final GetByIdUser getByIdUser;
    private final GetByUsernameUser getByUsernameUser;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO dto) {
        UserDomain userToCreate = toDomain(dto);
        UserDomain createdUser = createUser.execute(userToCreate);
        UserResponseDTO response = UserResponseDTO.fromDomain(createdUser);
        return ResponseEntity.created(URI.create("/api/v1/users" + response.id())).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable String id, @RequestBody UserRequestDTO dto) {
        UserDomain userToUpdate = toDomain(dto);
        userToUpdate.setId(id);
        UserDomain updatedUser = updateUser.execute(userToUpdate);
        UserResponseDTO response = UserResponseDTO.fromDomain(updatedUser);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<UserDomain> users = getAllUsers.execute(null);
        List<UserResponseDTO> response = UserResponseDTO.fromDomain(users);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable String id) {
        UserDomain user = getByIdUser.execute(id);
        UserResponseDTO response = UserResponseDTO.fromDomain(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponseDTO> getByUsername(@PathVariable String username) {
        UserDomain user = getByUsernameUser.execute(username);
        UserResponseDTO response = UserResponseDTO.fromDomain(user);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteUser.execute(id);
        return ResponseEntity.noContent().build();
    }

    // Temporary method to convert DTO to Domain
    private UserDomain toDomain(UserRequestDTO dto) {
        return new UserDomain(
                null,
                dto.name(),
                dto.username(),
                dto.password(),
                dto.role()
        );
    }
}
