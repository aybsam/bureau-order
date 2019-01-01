package com.lismart.smartregie.converter;

import java.math.BigInteger;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.lismart.smartregie.domain.Service;
import com.lismart.smartregie.repository.ServiceRepository;
import com.lismart.smartregie.service.ServiceService;

@ManagedBean(name = "serviceConverterBean") 
@FacesConverter(value = "serviceConverter")
public class serviceConverter implements Converter{
	

	@Autowired
    private ServiceRepository serviceRepo;

	@Autowired
    private ServiceService serviceService;
	
	
    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component,
            String value) {
        long id = Long.parseLong(value);
      return serviceService.findById(id);
    }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
