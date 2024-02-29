package com.dmiagkov.bank.security.http;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class ErrorResponse {
    private final HttpStatus httpStatus;
    private final String message;
}
