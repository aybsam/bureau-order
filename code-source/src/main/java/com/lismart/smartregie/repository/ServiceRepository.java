package com.lismart.smartregie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lismart.smartregie.domain.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
	
	Service findById(long id);
}
