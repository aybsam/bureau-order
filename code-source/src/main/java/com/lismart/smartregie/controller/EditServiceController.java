package com.lismart.smartregie.controller;

import static org.omnifaces.util.Messages.addGlobalInfo;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import com.lismart.smartregie.domain.Service;
import com.lismart.smartregie.service.ServiceService;

@Named
@ViewScoped
public class EditServiceController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5157646356164445384L;

	@Autowired
	private ServiceService serviceService;

	private Service service;

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public void submit() {
		serviceService.save(service);
		addGlobalInfo("services.edited");
		PrimeFaces.current().executeScript("PF('editDlg').hide()");
	}

}
