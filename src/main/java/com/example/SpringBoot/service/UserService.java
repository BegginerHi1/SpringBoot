package com.example.SpringBoot.service;

import com.example.SpringBoot.model.User;

import java.util.List;

public interface UserService {

    List<User> list();

    User find(int id);

    void save(User user);

    void update(User user);

    void delete(int id);
}
