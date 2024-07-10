package com.example.simple.user.mapper;

import com.example.simple.user.controller.dto.AuthDto;
import com.example.simple.user.domain.Account;
import com.example.simple.user.domain.AccountStatus;
import org.mapstruct.Mapper;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface AccountDtoMapper {
    Account toEntity(AuthDto.SignUpRequest dto, AccountStatus status , Instant createdAt);
}
