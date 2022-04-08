package com.project.chessbooksapp.book.application.service;

import com.project.chessbooksapp.book.application.port.in.RoleService;
import com.project.chessbooksapp.book.application.port.out.RoleRepository;
import com.project.chessbooksapp.book.application.port.out.UserRepository;
import com.project.chessbooksapp.book.domain.Role;
import com.project.chessbooksapp.book.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User addUserToRole(Long userId, String authority) {
        log.info("Adding role {} to user ", authority);

        Objects.requireNonNull(userId);
        Objects.requireNonNull(authority);

        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Could not find user with given id"));

        Role role = this.roleRepository.findByAuthority(authority)
                .orElseThrow(() -> new EntityNotFoundException("Could not find role with given name"));

        user.getAuthorities().add(role);

        return this.userRepository.save(user);
    }
}
