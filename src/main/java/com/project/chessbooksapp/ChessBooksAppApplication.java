package com.project.chessbooksapp;

import com.project.chessbooksapp.book.application.port.in.RoleService;
import com.project.chessbooksapp.book.application.port.in.UserService;
import com.project.chessbooksapp.book.application.port.out.RoleRepository;
import com.project.chessbooksapp.book.domain.Role;
import com.project.chessbooksapp.book.domain.User;
import com.project.chessbooksapp.security.request.CreateUserRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class ChessBooksAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessBooksAppApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
