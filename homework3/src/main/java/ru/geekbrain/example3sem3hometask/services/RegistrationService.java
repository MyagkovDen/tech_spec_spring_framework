package ru.geekbrain.example3sem3hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrain.example3sem3hometask.domain.User;

@Service
public class RegistrationService {
    /**
     * Сервис обработкт данных
     */
    private DataProcessingService dataProcessingService;
    /**
     * Сервис пользователя
     */
    private final UserService userService;
    /**
     * Сервис уведомлений
     */
    private final NotificationService notificationService;

    /**
     * Конструктор с параметрами
     * @param dataProcessingService
     * @param userService
     * @param notificationService
     */
    @Autowired
    public RegistrationService(DataProcessingService dataProcessingService,
                               UserService userService,
                               NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }


    /**
     * Метод региатрации пользователя
     * @param name Имя пользователя
     * @param age Возраст пользователя
     * @param email Электронная почта пользователя
     */
    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.notifyUser(user);
    }
}
