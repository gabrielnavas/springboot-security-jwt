package com.navas.security.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @PreAuthorize("hasAuthority('admin:create')")
    @PostMapping()
    public String authorityCreate() {
        return "admin has authority 'admin:create'";
    }

    @PreAuthorize("hasAuthority('admin:read')")
    @GetMapping()
    public String authorityRead() {
        return "admin has authority 'admin:read'";
    }

    @PreAuthorize("hasAuthority('admin:update')")
    @PatchMapping()
    public String authorityUpdate() {
        return "admin has authority 'admin:update'";
    }

    @PreAuthorize("hasAuthority('admin:delete')")
    @DeleteMapping()
    public String authorityDelete() {
        return "admin has authority 'admin:delete'";
    }
}
