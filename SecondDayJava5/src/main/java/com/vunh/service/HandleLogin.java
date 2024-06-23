package com.vunh.service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class HandleLogin implements ConstraintValidator<CheckLogin, String> {
    @Override
    public boolean isValid(String user, ConstraintValidatorContext constraintValidatorContext) {
        List<String> password = List.of("123", "321");
        return password.contains(user);
    }
}
