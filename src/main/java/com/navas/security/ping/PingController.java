package com.navas.security.ping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/ping")
@RequiredArgsConstructor
public class PingController {

    @GetMapping
    public String ping() {
        return "I am online!!";
    }
}
