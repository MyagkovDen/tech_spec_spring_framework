package com.dmiagkov.bank.application.service.impl;

import com.dmiagkov.bank.application.dto.incoming.UserRegisterDto;
import com.dmiagkov.bank.application.dto.outgoing.UserDto;
import com.dmiagkov.bank.application.mapper.UserMapper;
import com.dmiagkov.bank.application.repository.UserRepository;
import com.dmiagkov.bank.application.service.UserService;
import com.dmiagkov.bank.application.service.exceptions.LoginIsNotUniqueException;
import com.dmiagkov.bank.application.service.exceptions.PlayerAlreadyExistsException;
import com.dmiagkov.bank.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto registerUser(UserRegisterDto userRegisterDto) {
        if (userRepository.existsByLogin(userRegisterDto.getLogin())) {
            throw new LoginIsNotUniqueException(userRegisterDto.getLogin());
        } else {
            User toRegisterUser = userMapper.userRegisterDtoToUser(userRegisterDto);
            User registeredUser = userRepository.save(toRegisterUser);
            return userMapper.userToUserDto(registeredUser);
        }
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.usersToUserDtos(users);
    }

    public UserDto getUserDto(String login) {
        User user = userRepository.findUserByLogin(login);
        return userMapper.userToUserDto(user);

    }
}
