package com.example.homework11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel messageChannelInput() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel messageChannelFileWriter() {
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "messageChannelInput", outputChannel = "messageChannelFileWriter")
    public GenericTransformer<String, String> myTransformer() {
        return String::toUpperCase;
    }

    @Bean
    @ServiceActivator(inputChannel = "messageChannelFileWriter")
    public FileWritingMessageHandler myFileWriter() {
        FileWritingMessageHandler messageHandler = new FileWritingMessageHandler(
                new File("integration/")
        );
        messageHandler.setExpectReply(false);
        messageHandler.setFileExistsMode(FileExistsMode.APPEND);
        messageHandler.setAppendNewLine(true);
        return messageHandler;
    }
}
