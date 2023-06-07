package com.example.book.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.book.repository.IUserRepository;
import com.example.book.validator.annotation.ValidUsername;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValiUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if(userRepository==null)
             return true;
       return userRepository.findByUsername(username)==null;
    }
}
