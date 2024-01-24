package io.menglibay.realestateproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @PreAuthorize("hasRole('admin')")
    @GetMapping("/securedResource")
    public ResponseEntity<String> getSecuredResource() {
        return ResponseEntity.ok("This is a secured resource for admin");
    }
}
