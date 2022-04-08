package com.project.chessbooksapp.book.adapter.in.web;

import com.project.chessbooksapp.book.application.port.in.UserService;
import com.project.chessbooksapp.book.domain.User;
import com.project.chessbooksapp.security.JWTUtil;
import com.project.chessbooksapp.security.request.AuthUserRequest;
import com.project.chessbooksapp.security.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody @Valid AuthUserRequest authUserRequest){
        try {
            Authentication authentication = this.authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authUserRequest.getUsername(), authUserRequest.getPassword()));
            User user = (User) authentication.getPrincipal();
            System.out.println(user.getUsername() + " " + user.getPassword());
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, this.jwtUtil.generateAccessToken(user))
                    .body(user);
        }catch(BadCredentialsException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody @Valid CreateUserRequest createUserRequest){
        try {
            return ResponseEntity.ok().body(userService.createUser(createUserRequest));
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

