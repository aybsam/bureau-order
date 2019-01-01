package com.lismart.smartregie.controller;

import com.lismart.smartregie.domain.Courrier;
import com.lismart.smartregie.domain.Email;
import com.lismart.smartregie.domain.User;
import com.lismart.smartregie.exception.EmailExistsException;
import com.lismart.smartregie.service.CourrierService;
import com.lismart.smartregie.service.UserService;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.omnifaces.util.Messages.addGlobalInfo;

@ManagedBean
@RequestScoped
public class CourrierController implements Serializable {

    @Autowired
    private UserService userService;

    @Autowired
    private CourrierService courrierService;

    @Autowired
    private EditCourrierController editCourrierController;

    private User user;


    private Courrier courrier;
    private String source;
    private String destination;
    private List<User> users;
    private List<Courrier> courriers;
    private List<Courrier> filtredCourriers;
    private List<Courrier> selectedCourriers;

    @PostConstruct
    public void init() {
        courrier = new Courrier();
        source = "";
        destination = "";
        users = new ArrayList<User>();

        // pour initialiser le combo
        UserDetails springUser = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        user = userService.findByEmail(Email.of(springUser.getUsername()));


        if(springUser.getAuthorities().equals("ROLE_ADMIN")){
            courriers = courrierService.findAll();

        }else{
            courriers = courrierService.findAllByAuthor();
        }
        users = userService.findAll();
    }

    public String valider() {

        courrier.setSource(getSourcebyName(source));
        courrier.setDestination(getDestinationbyName(destination));

        try {
            courrierService.save(courrier);
        } catch (EmailExistsException e) {
            Messages.addGlobalError("Erreur", e.getMessage());
        }

        return "/courriers/list.xhtml?faces-redirect=true";
    }


    public User getSourcebyName(String name) {

        User u = new User();
        for (User user : users) {
            if (source.equals(user.toString()))
                u = user;
        }

        return u;

    }

    public User getSourcebyCode(Long id) {

        User u = new User();
        for (User user : users) {
            if (user.getId() == id)
                u = user;
        }

        return u;

    }

    public User getDestinationbyName(String name) {

        User u = new User();
        for (User user : users) {
            if (destination.equals(user.toString()))
                u = user;
        }

        return u;

    }

    public Courrier getCourrier() {
        return courrier;
    }

    public void setCourrier(Courrier courrier) {
        this.courrier = courrier;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Courrier> getCourriers() {
        return courriers;
    }

    public void setCourriers(List<Courrier> courriers) {
        this.courriers = courriers;
    }

    public List<Courrier> getFiltredCourriers() {
        return filtredCourriers;
    }

    public void setFiltredCourriers(List<Courrier> filtredCourriers) {
        this.filtredCourriers = filtredCourriers;
    }

    public List<Courrier> getSelectedCourriers() {
        return selectedCourriers;
    }

    public void setSelectedCourriers(List<Courrier> selectedCourriers) {
        this.selectedCourriers = selectedCourriers;
    }


    public void delete() {
        for (Courrier courrier : selectedCourriers) {
            courrierService.delete(courrier);
            courriers.remove(courrier);
        }

        Messages.addGlobalInfo("users.deleted");

    }

    public void send(Courrier courrier) {
        editCourrierController.setCourrier(courrier);
    }


    public void submit() {
        try {
            courrierService.save(courrier);
        } catch (EmailExistsException e) {

            //TODO : send error message to email component
            e.printStackTrace();
        }

        addGlobalInfo("courriers.edited");
        PrimeFaces.current().executeScript("PF('editDlg').hide()");
    }


}
