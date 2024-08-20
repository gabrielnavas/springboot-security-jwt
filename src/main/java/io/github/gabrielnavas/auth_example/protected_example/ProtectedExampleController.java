package io.github.gabrielnavas.auth_example.protected_example;

import io.github.gabrielnavas.auth_example.user.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/protected")
public class ProtectedExampleController {

    @GetMapping("/no-role")
    public String noRole(
            Authentication connectedUser
    ) {
        User user = ((User) connectedUser.getPrincipal());
        return String.format("i'm protected route, but no role is needed. user %s", user.getId());
    }


    @GetMapping("/admin-role")
    public String adminRole(
            Authentication connectedUser
    ) {
        User user = ((User) connectedUser.getPrincipal());
        return String.format("i'm protected route, but admin role is needed. user %s", user.getId());
    }
}
