package com.lismart.smartregie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lismart.smartregie.domain.Courrier;
import com.lismart.smartregie.domain.Email;
import com.lismart.smartregie.domain.User;
import com.lismart.smartregie.exception.EmailExistsException;
import com.lismart.smartregie.repository.CourrierRepository;

@Service
public class CourrierServiceImpl implements CourrierService {

    @Autowired
    private CourrierRepository courrierRepository;


    @Override
    public List<Courrier> findAll() {
        return courrierRepository.findAll();
    }

    @Override
    public List<Courrier> findAllByAuthor(Long idUser) {
       return courrierRepository.findAllByAuthor(idUser);
    }


    @Override
    @Transactional
    public void save(Courrier courrier) throws EmailExistsException {

        courrierRepository.save(courrier);
    }

    @Override
    public void delete(Courrier courrier) {
    	courrierRepository.delete(courrier);
    }

}
