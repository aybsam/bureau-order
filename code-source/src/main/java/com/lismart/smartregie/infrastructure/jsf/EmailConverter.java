package com.lismart.smartregie.infrastructure.jsf;


import com.lismart.smartregie.domain.Email;
import org.omnifaces.util.Messages;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Email.class)
public class EmailConverter implements Converter<Email> {

    @Override
    public Email getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s != null) {
            try {
                return Email.of(s);
            } catch (Exception e) {
                throw new ConverterException(Messages.createError("invalid.email", "email"));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Email email) {
        if (email != null) {
            return email.toString();
        }
        return null;
    }
}
