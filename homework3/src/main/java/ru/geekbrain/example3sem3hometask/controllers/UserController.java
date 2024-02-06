package ru.geekbrain.example3sem3hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrain.example3sem3hometask.domain.User;
import ru.geekbrain.example3sem3hometask.services.RegistrationService;
import ru.geekbrain.example3sem3hometask.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    /**
     * Метод создает нового пользователя с параметрами, извлеченными из http-запроса,
     * и добавлет его в репозиторий
     *
     * @param name  Имя пользователя
     * @param age   Возраст пользователя
     * @param email Электронная почта пользователя
     * @return String Информационное сообщение
     */
    @GetMapping("/param")
    public String userAddFromParam(@RequestParam("name") String name,
                                   @RequestParam("age") int age,
                                   @RequestParam("email") String email) {
        User user = userService.createUser(name, age, email);
        userList().add(user);
        return "User added from param!";
    }
}
