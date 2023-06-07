package com.example.book.Model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.book.repository.IUserRepository;

public class CustomUserDetail implements UserDetails {
    private final user users;
    private final IUserRepository userRepository;
    public CustomUserDetail(user users,IUserRepository userRepository){
        this.users = users;
        this.userRepository = userRepository;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        String[] roles = userRepository.getRolesOfUser(users.getId());
        for (String role : roles) {

            authorities.add(new SimpleGrantedAuthority(role));
        }

        return authorities;
    }

   
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return users.getPassword();
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return users.getUsername();
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
