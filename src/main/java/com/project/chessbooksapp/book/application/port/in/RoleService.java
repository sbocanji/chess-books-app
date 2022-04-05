package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.domain.User;

public interface RoleService {

    String ROLE_USER = "USER";
    String ROLE_ADMIN = "ADMIN";

    User addUserToRole(Long userId, String authority);
}
