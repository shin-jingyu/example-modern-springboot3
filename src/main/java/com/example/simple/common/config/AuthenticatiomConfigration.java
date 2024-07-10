package com.example.simple.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthenticatiomConfigration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        final  String PREFIX = "{bcrypt}";



        return new BCryptPasswordEncoder(){
            @Override
            public String encode(CharSequence rawPassword) {
                return PREFIX+super.encode(rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                encodedPassword = encodedPassword.substring(PREFIX.length());
                return super.matches(rawPassword, encodedPassword);
            }
        };
    }

}
