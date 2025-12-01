package com.example.DoctorDesk.security;

import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.DoctorDesk.users.Entity.User;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthUser implements UserDetails {
    
    private User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles()
                    .stream()
                    .map(Role-> new SimpleGrantedAuthority(Role.getName()))
                    .toList();
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

}
