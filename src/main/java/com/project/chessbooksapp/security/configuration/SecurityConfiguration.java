package com.project.chessbooksapp.security.configuration;

import com.project.chessbooksapp.book.application.port.out.UserRepository;
import com.project.chessbooksapp.security.filter.JWTFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static java.lang.String.format;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserRepository userRepository;
    private final JWTFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(format("User %s not found", username))));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http = http.cors().disable();
        http = http.csrf().disable();

        http = http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        http = http.exceptionHandling().
                authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.sendError(
                            httpServletResponse.SC_UNAUTHORIZED,
                            e.getMessage()
                    );
                }).and();

        http.authorizeRequests().antMatchers("/auth/**").permitAll().anyRequest().authenticated();


        http.addFilterBefore(
                this.jwtFilter,
                UsernamePasswordAuthenticationFilter.class
        );

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
