package com.example.simple.user.service;

import com.example.simple.user.controller.dto.AuthDto;
import com.example.simple.user.domain.Account;
import com.example.simple.user.domain.AccountStatus;
import com.example.simple.user.mapper.AccountDtoMapper;
import com.example.simple.user.repository.AccountRepository;
import com.example.simple.user.usercase.SignUpUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements SignUpUseCase {
    private final AccountRepository accountRepository;
    private final AccountDtoMapper mapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Account signUp(Account account) {


        String rawPassword = account.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        account.updatePassword(encodedPassword);
        return accountRepository.save(account);
    }

    @Override
    public Account signUp(AuthDto.SignUpRequest dto, AccountStatus status, Instant createdAt) {

        Account account = mapper.toEntity(dto,AccountStatus.ACTIVE,Instant.now());
        Account savedAccount = signUp(account) ;

        return savedAccount;
    }
}
