package com.dmiagkov.bank.utils;

import com.dmiagkov.bank.config.yaml.DatasourceConfig;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConnectionManager {

    private final DatasourceConfig config;

    public Connection open() {
        try {
            return DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
