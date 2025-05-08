package com.example.library.librarysystem.service;

import java.util.List;
import java.util.Optional;

import com.example.library.librarysystem.entity.Authorities;

public interface AuthoritiesService {
    List<Authorities> getAllAuthorities();
    Optional<Authorities> getAuthorityById(Long id);
    Authorities createAuthority(Authorities authority);
    Authorities updateAuthority(Long id, Authorities authority);
    void deleteAuthority(Long id);
}
