// package com.example.book.service;

// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import com.example.book.Model.user;

// public class UserDetailService implements UserDetails {
//     private final user users;
//     public void CustomUserDetail(user usern)
//     {
//         this.users = usern;
//     }
//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         // TODO Auto-generated method stub
//         return Collection.emptyList;
//     }
//     @Override
//     public String getPassword() {
//         // TODO Auto-generated method stub
//         return null;
//     }
//     @Override
//     public String getUsername() {
//         // TODO Auto-generated method stub
//         return null;
//     }
//     @Override
//     public boolean isAccountNonExpired() {
//         // TODO Auto-generated method stub
//         return false;
//     }
//     @Override
//     public boolean isAccountNonLocked() {
//         // TODO Auto-generated method stub
//         return false;
//     }
//     @Override
//     public boolean isCredentialsNonExpired() {
//         // TODO Auto-generated method stub
//         return false;
//     }
//     @Override
//     public boolean isEnabled() {
//         // TODO Auto-generated method stub
//         return false;
//     }
// }
