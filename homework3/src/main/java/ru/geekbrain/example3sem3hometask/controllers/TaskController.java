package ru.geekbrain.example3sem3hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrain.example3sem3hometask.domain.User;
import ru.geekbrain.example3sem3hometask.repository.UserRepository;
import ru.geekbrain.example3sem3hometask.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Метод реализует фильтрацию пользователей по возрасту
     *
     * @param age Возраст пользователя
     * @return List<User> Список пользователей
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        List<User> users = getAllUsers();
        return service.filterUsersByAge(users, age);
    }

    /**
     * Метод вычисляет средний возраст пользователей
     *
     * @return double Средний возраст
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        List<User> users = getAllUsers();
        return service.calculateAverageAge(users);
    }

    /**
     * Список возвращает список всех пользователейиз репозитория
     *
     * @return List<User> Список пользователей
     */
    private List<User> getAllUsers() {
        UserRepository repository = service.getRepository();
        List<User> users = repository.getUsers();
        return users;
    }
}
