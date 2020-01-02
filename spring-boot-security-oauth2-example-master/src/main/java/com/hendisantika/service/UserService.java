package com.hendisantika.service;

import com.hendisantika.model.User;

import java.util.List;


public interface UserService {

    User save(User user);

    List<User> findAll();

    void delete(long id);
}
