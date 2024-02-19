package com.example.empl4sem2CRUD.repositories.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "sql")
@Data
public class SqlBuilder {
    private String selectAllUsers;
    private String addUser;
    private String deleteUser;
    private String updateUser;
    private String selectUser;
}
