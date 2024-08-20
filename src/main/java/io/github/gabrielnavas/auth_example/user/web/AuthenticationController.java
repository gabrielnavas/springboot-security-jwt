package io.github.gabrielnavas.auth_example.user.web;

import io.github.gabrielnavas.auth_example.user.dto.SaveUserDto;
import io.github.gabrielnavas.auth_example.user.dto.SigninDto;
import io.github.gabrielnavas.auth_example.user.dto.SignupDto;
import io.github.gabrielnavas.auth_example.user.dto.TokenDto;
import io.github.gabrielnavas.auth_example.user.service.AuthenticationService;
import io.github.gabrielnavas.auth_example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody SignupDto dto) {
        userService.saveUser(SaveUserDto.builder()
                .firstname(dto.firstname())
                .lastname(dto.lastname())
                .dateOfBirth(dto.dateOfBirth())
                .email(dto.email())
                .password(dto.password())
                .build()
        );
    }

    @PostMapping("/signin")
    public TokenDto signin(@RequestBody SigninDto dto) {
        return authenticationService.signin(dto);
    }
}
