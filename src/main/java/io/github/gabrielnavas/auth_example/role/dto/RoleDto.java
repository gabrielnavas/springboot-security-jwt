package io.github.gabrielnavas.auth_example.role.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record RoleDto(
        UUID id,
        String name
) {
}
