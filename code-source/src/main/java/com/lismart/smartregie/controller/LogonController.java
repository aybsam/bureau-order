package com.lismart.smartregie.controller;

import com.lismart.smartregie.domain.User;
import com.lismart.smartregie.service.UserService;
import com.lismart.smartregie.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LogonController implements Serializable {

    @Autowired
    private UserService userService;

    private User user;

    @PostConstruct
    public void init() {
        UserDetails springUser = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        user = userService.findByEmail(Email.of(springUser.getUsername()));
    }

    public User getUser() {
        return user;
    }

    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }

}
