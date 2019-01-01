package com.lismart.smartregie.controller;

import com.lismart.smartregie.domain.User;
import com.lismart.smartregie.exception.EmailExistsException;
import com.lismart.smartregie.service.UserService;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

import static org.omnifaces.util.Messages.addGlobalInfo;

@Named
@ViewScoped
public class EditUserController implements Serializable {

    @Autowired
    private UserService userService;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void submit() {
        try {
            userService.save(user);
        } catch (EmailExistsException e) {

            //TODO : send error message to email component
            e.printStackTrace();
        }

        addGlobalInfo("users.edited");
        PrimeFaces.current().executeScript("PF('editDlg').hide()");
    }

}
