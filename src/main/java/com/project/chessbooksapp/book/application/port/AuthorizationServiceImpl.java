package com.project.chessbooksapp.book.application.port;

import com.project.chessbooksapp.book.application.port.in.AuthorizationService;
import com.project.chessbooksapp.book.domain.Role;
import com.project.chessbooksapp.book.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated())
            return null;

        return (User) authentication.getPrincipal();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Role> getAuthorizedUserRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated())
            return null;

        return (Set<Role>) authentication.getAuthorities();
    }
}
