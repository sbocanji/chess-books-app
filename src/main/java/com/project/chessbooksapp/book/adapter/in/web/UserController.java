package com.project.chessbooksapp.book.adapter.in.web;

import com.project.chessbooksapp.book.application.port.in.UserService;
import com.project.chessbooksapp.book.domain.User;
import com.project.chessbooksapp.security.request.AuthUserRequest;
import com.project.chessbooksapp.security.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody @Valid AuthUserRequest authUserRequest){
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid CreateUserRequest createUserRequest){
        try {
            return ResponseEntity.ok().body(userService.createUser(createUserRequest));
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

