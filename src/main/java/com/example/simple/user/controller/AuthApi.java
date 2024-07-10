package com.example.simple.user.controller;

import com.example.simple.user.controller.dto.AuthDto;
import com.example.simple.user.domain.Account;
import com.example.simple.user.domain.AccountStatus;
import com.example.simple.user.usercase.SignUpUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class AuthApi {

    private final  SignUpUseCase signUpUseCase;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @Valid AuthDto.SignUpRequest body) {
        signUpUseCase.signUp(body, AccountStatus.ACTIVE, Instant.now());
    }
}
