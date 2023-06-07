package com.example.book.validator.annotation;
import com.example.book.validator.ValiUserIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValiUserIdValidator.class)
@Documented
public @interface ValiUserId {
    String message() default"Invalid User ID";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
    
}
