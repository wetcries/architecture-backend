package com.example.backend.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

public enum ClientRole {
    CLIENT,
    ADMIN;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        return Set.of(new SimpleGrantedAuthority("ROLE_" + this.name()));
    }
}
