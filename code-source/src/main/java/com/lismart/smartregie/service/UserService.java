package com.lismart.smartregie.service;

import com.lismart.smartregie.domain.User;
import com.lismart.smartregie.exception.EmailExistsException;
import com.lismart.smartregie.domain.Email;

import java.util.List;

public interface UserService {
    void save(User user) throws EmailExistsException;
    void delete(User user);
    List<User> findAll();
    User findByEmail(Email email);
}
