package com.example.book.validator.annotation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;

import java.lang.annotation.Target;

import com.example.book.validator.ValiUsernameValidator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target({TYPE,FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValiUsernameValidator.class)
public @interface ValidUsername {
    String message() default "Username already exists";
    Class<?>[]groups() default{};
    Class<? extends  Payload>[] payload() default{};
}
