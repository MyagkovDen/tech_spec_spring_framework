package com.example.empl4sem2CRUD.repositories;

import com.example.empl4sem2CRUD.model.User;
import com.example.empl4sem2CRUD.repositories.util.SqlBuilder;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;
    SqlBuilder sqlBuilder;


    public List<User> findAll() {
        String sql = sqlBuilder.getSelectAllUsers();

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = sqlBuilder.getAddUser();
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        String sql = sqlBuilder.getDeleteUser();
        jdbc.update(sql, id);
    }

    public User update(User user) {
        String sql = sqlBuilder.getUpdateUser();
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }

    public User find(int id) {
        String sql = sqlBuilder.getSelectUser();
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.queryForObject(sql, userRowMapper, id);
    }
}
