package com.lismart.smartregie.controller;

import com.lismart.smartregie.domain.Courrier;
import com.lismart.smartregie.exception.EmailExistsException;
import com.lismart.smartregie.service.CourrierService;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

import static org.omnifaces.util.Messages.addGlobalInfo;

@Named
@ViewScoped
public class EditCourrierController implements Serializable {

    @Autowired
    private CourrierService courrierService;

    private Courrier courrier;

    public Courrier getCourrier() {
        return courrier;
    }

    public void setCourrier(Courrier courrier) {
        this.courrier = courrier;
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
