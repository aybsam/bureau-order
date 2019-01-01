package com.lismart.smartregie.controller;

import com.lismart.smartregie.domain.User;
import com.lismart.smartregie.service.ServiceService;
import com.lismart.smartregie.service.UserService;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListUserController implements Serializable {

    @Autowired
    private UserService userService;

    @Autowired
    private EditUserController editUserController;

    private List<User> users;
    private List<User> selectedUsers;
    private List<User> filteredUsers;

    @PostConstruct
    public void init() {
        users = userService.findAll();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(List<User> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public List<User> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(List<User> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }

    public void delete() {
        for (User user : selectedUsers) {
            userService.delete(user);
            users.remove(user);
        }

        Messages.addGlobalInfo("users.deleted");

    }

    public void send(User user) {
        editUserController.setUser(user);
    }
}
