package com.dmiagkov.bank.application.dto.incoming;

import com.dmiagkov.bank.domain.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRegisterDto {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("role")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Role role;

    @JsonProperty("login")
    private String login;

    @JsonProperty("password")
    private String password;
}
