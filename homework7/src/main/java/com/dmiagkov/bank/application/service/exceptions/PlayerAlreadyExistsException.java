package com.dmiagkov.bank.application.service.exceptions;

import com.dmiagkov.bank.application.dto.incoming.UserRegisterDto;

public class PlayerAlreadyExistsException extends RuntimeException {
    public PlayerAlreadyExistsException(UserRegisterDto userRegisterDto) {
        super("Пользователь " + userRegisterDto +
              "уже зарегистрирован. Дублирование игроков не допускается");
    }
}
