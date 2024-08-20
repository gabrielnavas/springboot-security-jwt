package io.github.gabrielnavas.auth_example.user.repository;

import io.github.gabrielnavas.auth_example.user.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}
