package com.lismart.smartregie.controller;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import com.lismart.smartregie.domain.Service;
import com.lismart.smartregie.service.ServiceService;

@ManagedBean
@RequestScoped
public class NewServiceController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2689897759689614096L;

	@Autowired
	private ServiceService serviceService;

	private Service service;

	@PostConstruct
	public void init() {
		service = new Service();
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public String submit() {
		serviceService.save(service);
		Messages.addFlashGlobalInfo("services.added");
		return "/services/list.xhtml?faces-redirect=true";
	}
}
