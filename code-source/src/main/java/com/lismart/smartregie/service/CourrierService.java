package com.lismart.smartregie.service;

import java.util.List;

import com.lismart.smartregie.domain.Courrier;
import com.lismart.smartregie.domain.User;
import com.lismart.smartregie.exception.EmailExistsException;

public interface CourrierService {
    void save(Courrier courrier) throws EmailExistsException;
    void delete(Courrier courrier);
    List<Courrier> findAll();
    //List<Courrier> findAllByAuthor(Long idUser);

    
}
