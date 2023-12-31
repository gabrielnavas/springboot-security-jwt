package com.navas.security;

import com.navas.security.auth.AuthenticationService;
import com.navas.security.auth.RegisterRequest;
import com.navas.security.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var intern = RegisterRequest.builder()
                    .firstname("Maria")
                    .lastname("Silva")
                    .email("maria.silva@mail.com")
                    .password("password")
                    .role(Role.INTERN)
                    .build();
            System.out.println("Intern token: " + service.register(intern).getToken());


            var user = RegisterRequest.builder()
                    .firstname("John")
                    .lastname("Lopes")
                    .email("john.lopes@mail.com")
                    .password("password")
                    .role(Role.USER)
                    .build();
            System.out.println("User token: " + service.register(user).getToken());

            var manager = RegisterRequest.builder()
                    .firstname("Manager")
                    .lastname("Manager")
                    .email("manager@mail.com")
                    .password("password")
                    .role(Role.MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getToken());

            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(Role.ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getToken());

        };
    }

}
