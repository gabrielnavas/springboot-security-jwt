## A arquitetura usada no projeto para authenticação.

![img.png](readme-images/architecture.png)

### Docker compose

#### Vamos adicionar o docker-compose para usar o postgresql

```docker
version: '3.1'

services:
  db:
    image: postgres:14.3
    restart: always
    environment:
      POSTGRES_PASSWORD: postgres123
    ports:
      - "5435:5432"
```

### Role

#### Usado para especificar qual tipo de User é.

```java
package com.navas.security.user;

public enum Role {
    USER,
    ADMIN
}
```

### User Model

#### A classe User está o mais simples possível, ela implementa o UserDetails que é o User do SpringBoot.

```java
package com.navas.security.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String firstname;
    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
```

### UserRepository

#### Para buscar os dados do User usaremos a interface UserRepository

```java
package com.navas.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
```
