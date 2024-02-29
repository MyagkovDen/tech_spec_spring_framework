package com.dmiagkov.bank.infrastructure.in.controller;

import com.dmiagkov.bank.application.dto.incoming.UserRegisterDto;
import com.dmiagkov.bank.application.dto.outgoing.UserDto;
import com.dmiagkov.bank.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @GetMapping("/private-data/users")
    public ResponseEntity<List<UserDto>> registerUser() {
        List<UserDto> userDto = userService.getUsers();
        return ResponseEntity.status(HttpStatus.OK)
                .body(userDto);
    }

    @RequestMapping(value = "/public-data", method = RequestMethod.GET)
    public String hello_get() {
        return "Hello World!";
    }

}
