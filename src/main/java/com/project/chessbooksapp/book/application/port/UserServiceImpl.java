package com.project.chessbooksapp.book.application.port;

import com.project.chessbooksapp.book.application.port.in.RoleService;
import com.project.chessbooksapp.book.application.port.in.UserService;
import com.project.chessbooksapp.book.application.port.out.UserRepository;
import com.project.chessbooksapp.book.domain.User;
import com.project.chessbooksapp.security.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import javax.xml.bind.ValidationException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Service @Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    // Method from UserDetailsService interface
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new EntityNotFoundException("User with given username does not exist!"));
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getAuthorities().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User createUser(CreateUserRequest createUserRequest) throws ValidationException {
        log.info("Creating new user {} ", createUserRequest.getUsername());

        Objects.requireNonNull(createUserRequest);

        if (this.userRepository.findByUsername(createUserRequest.getUsername()).isPresent())
            throw new ValidationException("User with given username already exists!");

        if (!createUserRequest.getPassword().equals(createUserRequest.getRePassword()))
            throw new ValidationException("Passwords do not match");

        User user = new User();
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(this.passwordEncoder.encode(createUserRequest.getPassword()));

        user = this.userRepository.save(user);

        user = this.roleService.addUserToRole(user.getId(), RoleService.ROLE_USER);

        return user;
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving user {} to the database", user.getUsername());
        Objects.requireNonNull(user);
        Objects.requireNonNull(user.getId());

        this.userRepository.findById(user.getId()).orElseThrow(() ->
                new EntityNotFoundException("User with given id does not exist!")
        );

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        log.info("Fetching user {} ", username);
        return userRepository.findByUsername(username).orElseThrow(() ->
                new EntityNotFoundException("User with given username does not exist!"));
    }

    @Override
    public User findById(Long id) {
        Objects.requireNonNull(id);

        return this.userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User with given id does not exist!"));
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}
