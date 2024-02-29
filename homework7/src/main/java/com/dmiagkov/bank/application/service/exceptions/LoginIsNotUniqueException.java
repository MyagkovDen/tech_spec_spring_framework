package com.dmiagkov.bank.application.service.exceptions;

public class LoginIsNotUniqueException extends RuntimeException{
    public LoginIsNotUniqueException(String login) {
        super("Логин '" + login + "' не является уникальным");
    }
}
