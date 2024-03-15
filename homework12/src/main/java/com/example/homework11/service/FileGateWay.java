package com.example.homework11.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "messageChannelInput")
public interface FileGateWay {

    public void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);
}
