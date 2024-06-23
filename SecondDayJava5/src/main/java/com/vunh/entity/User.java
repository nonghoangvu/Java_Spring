package com.vunh.entity;

import com.vunh.service.CheckLogin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotBlank(message = "Please enter your username")
    private String username;
    @CheckLogin
    @NotBlank(message = "Please enter your password")
    private String password;
}
