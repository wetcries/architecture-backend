package com.example.backend.security.jwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Data
@Service
public class JwtConfig {
    @Value("${jwt.secretKey}")
    private String secretKey;
    @Value("${jwt.tokenExpirationAfterDays}")
    private int tokenExpirationAfterDays;
}
