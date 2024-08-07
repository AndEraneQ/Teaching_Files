package com.troja.securityDemo;

import com.troja.securityDemo.jwt.AuthEntryPointJwt;
import com.troja.securityDemo.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.JdbcUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;




@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests
                        .requestMatchers("/signin").permitAll()
                        .anyRequest().authenticated()
        );
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
        http.exceptionHandling(exception -> exception
                .authenticationEntryPoint(unauthorizedHandler)
        );
        http.headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions
                        .sameOrigin()
                )
        );
        //http.formLogin(withDefaults());
        //http.httpBasic(withDefaults());
        http.csrf(csrf -> csrf.
                disable()
        );
        http.addFilterBefore(authenticationJwtTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

//        UserDetails user1 = User.withUsername("user1")
//                .password(passwordEncoder().encode("password1"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("adminPass"))
//                .roles("ADMIN")
//                .build();

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

//        userDetailsManager.createUser(user1);
//        userDetailsManager.createUser(admin);

        return userDetailsManager;
        //return new InMemoryUserDetailsManager(user1,admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder)
            throws Exception {
        return builder.getAuthenticationManager();
    }
}
