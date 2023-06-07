package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.Model.role;
import com.example.book.Model.user;
import com.example.book.repository.IRoleRepository;
import com.example.book.repository.IUserRepository;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;


    @Autowired
    private IRoleRepository roleRepository;
    public void save(user users){
        userRepository.save(users);
        Long userId = userRepository.getUserIdByUsername(users.getUsername());
        long roleId = roleRepository.getRoleIdByName("USER");
        if(roleId !=0 && userId != null){
            userRepository.addRoleToUser(userId, roleId);
        }
    }
}
