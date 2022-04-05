package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.domain.Role;
import com.project.chessbooksapp.book.domain.User;

import java.util.Set;

public interface AuthorizationService {

    User getAuthenticatedUser();
    Set<Role> getAuthorizedUserRoles();
}
