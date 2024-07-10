package com.example.simple.user.usercase;

import com.example.simple.user.controller.dto.AuthDto;
import com.example.simple.user.domain.Account;
import com.example.simple.user.domain.AccountStatus;

import java.time.Instant;

public interface SignUpUseCase {
    Account signUp(Account account);
    Account signUp(AuthDto.SignUpRequest dto , AccountStatus status, Instant createdAt);
}
