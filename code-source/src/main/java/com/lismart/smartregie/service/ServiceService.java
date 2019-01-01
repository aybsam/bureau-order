package com.lismart.smartregie.service;

import java.util.List;
import java.util.Optional;

import com.lismart.smartregie.domain.Service;

public interface ServiceService {
	void save(Service service);

	void delete(Service service);
	
	Service findById(long id);


	List<Service> findAll();
}
