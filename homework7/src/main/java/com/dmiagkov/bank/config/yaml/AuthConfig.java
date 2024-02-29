package com.dmiagkov.bank.config.yaml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационные данные о секретных ключах Jwt-токенов
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "authentication")
public class AuthConfig {
    private String valueOfJwtAccessSecretKey;
    private String valueOfJwtRefreshSecretKey;
}
