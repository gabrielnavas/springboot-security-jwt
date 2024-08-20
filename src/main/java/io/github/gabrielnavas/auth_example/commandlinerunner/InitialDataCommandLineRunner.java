package io.github.gabrielnavas.auth_example.commandlinerunner;

import io.github.gabrielnavas.auth_example.role.service.RoleService;
import io.github.gabrielnavas.auth_example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitialDataCommandLineRunner implements CommandLineRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        addRoles();
        addUserAdmin();
    }

    public void addUserAdmin() {
        System.out.println("[ * ] STARTED ADD ADMIN USER.");
        userService.saveUserAdmin();
        System.out.println("[ * ] ENDED ADDED ADMIN USER.");
    }

    public void addRoles() {
        System.out.println("[ * ] STARTED VERIFYING ROLES.");
        roleService.saveInitialRoles();
        System.out.println("[ * ] ENDED VERIFYING ROLES.");
    }
}
