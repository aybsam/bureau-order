package com.lismart.smartregie.controller;

import com.lismart.smartregie.domain.Service;
import com.lismart.smartregie.service.ServiceService;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListServiceController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6710425251223697930L;

	@Autowired
    private ServiceService serviceService;

    @Autowired
    private EditServiceController editServiceController;

    private List<Service> services;
    private List<Service> selectedServices;
    private List<Service> filteredServices;

    @PostConstruct
    public void init() {
        services = serviceService.findAll();
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Service> getSelectedServices() {
        return selectedServices;
    }

    public void setSelectedServices(List<Service> selectedServices) {
        this.selectedServices = selectedServices;
    }

    public List<Service> getFilteredServices() {
        return filteredServices;
    }

    public void setFilteredServices(List<Service> filteredServices) {
        this.filteredServices = filteredServices;
    }

    public void delete() {
        for (Service service : selectedServices) {
            serviceService.delete(service);
            services.remove(service);
        }

        Messages.addGlobalInfo("services.deleted");

    }

    public void send(Service service) {
        editServiceController.setService(service);
    }
}
