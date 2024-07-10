package com.example.simple.user.controller.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public final class AuthDto {
    private AuthDto(){}

    @Builder
    public record SignUpRequest(
            @NotBlank
            @Pattern(regexp = "^[a-z]+[a-z0-9]{3,30}$")
            String username,

            @NotBlank
            @Pattern(regexp = "(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,100}$")
            String password,

            @NotBlank
            String nickname


    ){
        // 소괄호가 없는 생성자를 compact 생성자 이다
        public SignUpRequest{
            nickname = nickname.strip(); // 공백으로 보인는 유니코드상 문자 ' 제거

        }

    }
    public record SignUpResponse(){

    }

}
