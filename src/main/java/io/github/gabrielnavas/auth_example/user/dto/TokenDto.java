package io.github.gabrielnavas.auth_example.user.dto;

import lombok.Builder;

@Builder
public record TokenDto(
        String token
) {
}
