package com.dmiagkov.bank.application.repository;

import com.dmiagkov.bank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    User findUserByLogin(String login);

    boolean existsByLogin(String login);

    List<User> findAll();

}
