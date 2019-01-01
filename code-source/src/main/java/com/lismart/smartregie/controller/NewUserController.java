package com.lismart.smartregie.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import com.lismart.smartregie.domain.Role;
import com.lismart.smartregie.domain.Service;
import com.lismart.smartregie.domain.User;
import com.lismart.smartregie.exception.EmailExistsException;
import com.lismart.smartregie.service.RoleService;
import com.lismart.smartregie.service.ServiceService;
import com.lismart.smartregie.service.UserService;

@ManagedBean
@RequestScoped
public class NewUserController implements Serializable {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    
	@Autowired
    private ServiceService serviceService;
	
    private Service service;
	
	
    private User user;
    private String role;
    private String code;
    private List<Service> Allservices = new ArrayList<Service>();


    @PostConstruct
    public void init() {
        user = new User();
        role = "ROLE_USER"; // FIXME: 9/13/2018 fix
        this.setAllservices(serviceService.findAll());
        
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String submit() {
        Role selectedRole = roleService.findByName(role);
        user.setRoles(Arrays.asList(selectedRole));
        user.setService(FindserviceByCode1(code));
        try {
            userService.save(user);
        } catch (EmailExistsException e) {
            Messages.addGlobalError("Erreur : Email deja existant", e.getMessage());
            return null;
        }

        Messages.addFlashGlobalInfo("users.added");
        return "/users/list.xhtml?faces-redirect=true";
    }

	public List<Service> getAllservices() {
		return Allservices;
	}

	public void setAllservices(List<Service> allservices) {
		Allservices = allservices;
	}
	
	public String FindserviceByCode(String code) {
		if (code != null || code != "")
			for (Service service : Allservices) {
				if (service.getCode().equals(code)) {
					return service.getNom();
				}
			}
		return "";
	}
	
	public Service FindserviceByCode1(String code) {
		if (code != null || code != "")
			for (Service service : Allservices) {
				if (service.getCode().equals(code)) {
					return service;
				}
			}
		return null;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
