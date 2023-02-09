package com.example.apisecurity.service;

import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Jwt {

    @Getter
    private final String token;
    @Getter
    private final Long userId;
    @Getter
    private final LocalDateTime issuedAt;
    @Getter
    private final LocalDateTime expiredAt;

    public static Jwt of(Long userId,
                         Long validInMinutes,
                         String securityKey){
        var issueDate = Instant.now();
        var expiration = issueDate.plus(validInMinutes, ChronoUnit.SECONDS);

    }

    private Jwt(String token, Long userId, LocalDateTime issuedAt, LocalDateTime expiredAt) {
        this.token = token;
        this.userId = userId;
        this.issuedAt = issuedAt;
        this.expiredAt = expiredAt;
    }
}
