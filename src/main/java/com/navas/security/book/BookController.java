package com.navas.security.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    @GetMapping
    public String getAllBooks() {
        return "I am a book!!";
    }
}
