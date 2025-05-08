package com.example.library.librarysystem.service;

import org.springframework.stereotype.Service;

import com.example.library.librarysystem.dao.AuthoritiesDAO;
import com.example.library.librarysystem.entity.Authorities;

import java.util.List;
import java.util.Optional;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    private final AuthoritiesDAO authoritiesDAO;

    public AuthoritiesServiceImpl(AuthoritiesDAO authoritiesDAO) {
        this.authoritiesDAO = authoritiesDAO;
    }

    @Override
    public List<Authorities> getAllAuthorities() {
        return authoritiesDAO.findAll();
    }

    @Override
    public Optional<Authorities> getAuthorityById(Long id) {
        return authoritiesDAO.findById(id);
    }

    @Override
    public Authorities createAuthority(Authorities authority) {
        return authoritiesDAO.save(authority);
    }

    @Override
    public Authorities updateAuthority(Long id, Authorities authority) {
        if (authoritiesDAO.existsById(id)) {
            authority.setId(id);
            return authoritiesDAO.save(authority);
        }
        throw new RuntimeException("Authority not found");
    }

    @Override
    public void deleteAuthority(Long id) {
        authoritiesDAO.deleteById(id);
    }
}
