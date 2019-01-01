package com.lismart.smartregie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lismart.smartregie.domain.Service;
import com.lismart.smartregie.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(Service service) {
        serviceRepository.delete(service);
    }

    @Override
	public Service findById(long id) {
		return serviceRepository.findById(id);
	}
}
