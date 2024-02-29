package com.dmiagkov.bank.application.service;

import com.dmiagkov.bank.application.dto.incoming.UserRegisterDto;
import com.dmiagkov.bank.application.dto.outgoing.UserDto;
import com.dmiagkov.bank.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDto registerUser(UserRegisterDto userRegisterDto);

    UserDto getUserDto(String login);

    List<UserDto> getUsers();
}
