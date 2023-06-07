package com.example.book.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.book.Model.CustomUserDetail;
import com.example.book.Model.user;
import com.example.book.repository.IUserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    // @Override
    // public UserDetails loadUserByUsername(String username)
    //         throws UsernameNotFoundException {
    //     String pass;
    //     Set<GrantedAuthority> authorities = new HashSet<>();
    //     if (username == "admin") {
    //         pass = "admin";
    //         authorities.add(new SimpleGrantedAuthority("ADMIN"));
    //     } else if (username == "sales") {
    //         pass = "sales";
    //         authorities.add(new SimpleGrantedAuthority("SALES"));
    //     } else {
    //         pass = "user";
    //         authorities.add(new SimpleGrantedAuthority("USER"));
    //     }
    //     return new org.springframework.security.core.userdetails.User(
    //             username,
    //             new BCryptPasswordEncoder().encode(pass),
    //             authorities);
    // }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        user user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("user not found");
        return new CustomUserDetail(user,userRepository);
    }
}
