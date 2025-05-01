package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Abdi's API!";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity.ok()
                .header("X-Custom-Header", "AbdiHeader")
                .body("Success with custom header!");
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return ResponseEntity.status(404).body("Resource not found");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create() {
        return ResponseEntity.created(null).body("Resource created successfully");
    }
}