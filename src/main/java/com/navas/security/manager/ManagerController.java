package com.navas.security.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/manager")
@RequiredArgsConstructor
@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN') or hasRole('INTERN')")
public class ManagerController {

    @PostMapping()
    @PreAuthorize("hasAuthority('management:create')")
    public String authorityCreate() {
        return "manager has authority 'manager:create'";
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('management:read')")
    public String authorityRead() {
        return "manager has authority 'manager:read'";
    }

    @PatchMapping()
    @PreAuthorize("hasAuthority('management:update')")
    public String authorityUpdate() {
        return "manager has authority 'manager:update'";
    }

    @DeleteMapping()
    @PreAuthorize("hasAuthority('management:delete')")
    public String authorityDelete() {
        return "manager has authority 'manager:delete'";
    }
}
