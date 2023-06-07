package com.example.book.validator;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.example.book.Model.user;
import com.example.book.validator.annotation.ValiUserId;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValiUserIdValidator implements ConstraintValidator<ValiUserId,user> {
    @Override
    public boolean isValid(user users, ConstraintValidatorContext context){
        if(users==null)
        return true;
        return users.getId() !=null;
    }
} 
   
   