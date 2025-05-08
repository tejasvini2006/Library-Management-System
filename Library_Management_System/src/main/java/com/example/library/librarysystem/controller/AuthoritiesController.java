package com.example.library.librarysystem.controller;

import org.springframework.web.bind.annotation.*;

import com.example.library.librarysystem.entity.Authorities;
import com.example.library.librarysystem.service.AuthoritiesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authorities")
public class AuthoritiesController {

    private final AuthoritiesService authoritiesService;

    public AuthoritiesController(AuthoritiesService authoritiesService) {
        this.authoritiesService = authoritiesService;
    }

    @GetMapping
    public List<Authorities> getAllAuthorities() {
        return authoritiesService.getAllAuthorities();
    }

    @GetMapping("/{id}")
    public Optional<Authorities> getAuthorityById(@PathVariable Long id) {
        return authoritiesService.getAuthorityById(id);
    }

    @PostMapping
    public Authorities createAuthority(@RequestBody Authorities authority) {
        return authoritiesService.createAuthority(authority);
    }

    @PutMapping("/{id}")
    public Authorities updateAuthority(@PathVariable Long id, @RequestBody Authorities authority) {
        return authoritiesService.updateAuthority(id, authority);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthority(@PathVariable Long id) {
        authoritiesService.deleteAuthority(id);
    }
}
