package com.project.chessbooksapp.security.request;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String rePassword;
}
