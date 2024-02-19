package com.example.empl4sem2CRUD.service;

import com.example.empl4sem2CRUD.model.User;
import com.example.empl4sem2CRUD.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        return userRepository.update(user);
    }

    public User getOne(int id) {
        return userRepository.find(id);
    }
}
