package io.github.gabrielnavas.auth_example.user.service;

import io.github.gabrielnavas.auth_example.user.model.ERole;
import io.github.gabrielnavas.auth_example.user.model.Role;
import io.github.gabrielnavas.auth_example.user.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public void saveInitialRoles() {
        final Set<ERole> roleNames = Set.of(ERole.STUDENT, ERole.ADMIN, ERole.MANAGER);

        for (ERole roleName : roleNames) {
            Optional<Role> roleOptional = roleRepository.findByName(roleName);
            if (roleOptional.isEmpty()) {
                Role role = Role.builder()
                        .name(roleName)
                        .createdAt(LocalDateTime.now())
                        .build();
                roleRepository.save(role);
            }
        }
    }
}
