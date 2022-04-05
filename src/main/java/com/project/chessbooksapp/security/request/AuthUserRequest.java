package com.project.chessbooksapp.security.request;

import lombok.Getter;

@Getter
public class AuthUserRequest {
    private String username;
    private String password;
}
