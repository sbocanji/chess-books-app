package com.project.chessbooksapp.book.application.port.in;

import com.project.chessbooksapp.book.domain.User;
import com.project.chessbooksapp.security.request.CreateUserRequest;
import javax.xml.bind.ValidationException;
import java.util.List;

public interface UserService {
    User createUser(CreateUserRequest createUserRequest) throws ValidationException;
    User saveUser(User user);
    User findByUsername(String username);
    User findById(Long id);
    List<User> getUsers();
}
