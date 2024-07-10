package com.example.simple.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Account {
    @Id
    @GeneratedValue(generator = "uuri2")
    private UUID id;

    private String username;

    private String password;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private AccountStatus status ;

    private Instant createdAt;

    private Instant updatedAt;

    public void updatePassword(String password) {
        this.password = password;
    }
}
