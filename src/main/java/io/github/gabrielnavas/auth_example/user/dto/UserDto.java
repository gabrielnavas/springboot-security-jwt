package io.github.gabrielnavas.auth_example.user.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record UserDto(
        UUID id,
        String firstname,
        String lastname,
        LocalDate dateOfBirth,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<RoleDto> roles
) {
}
