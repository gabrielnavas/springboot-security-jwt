package io.github.gabrielnavas.auth_example.user.repository;

import io.github.gabrielnavas.auth_example.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("""
            SELECT u 
            FROM User u 
            WHERE upper(email) = upper(:email)
            """)
    Optional<User> findByEmailIgnoreCase(@Param("email") String email);
}
