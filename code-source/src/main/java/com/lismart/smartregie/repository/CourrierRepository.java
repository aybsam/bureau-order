package com.lismart.smartregie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lismart.smartregie.domain.Courrier;
import com.lismart.smartregie.domain.Email;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourrierRepository extends JpaRepository<Courrier, Long> {

    @Query("FROM courrier c where c.id_destination =:idUser")
    public List<Courrier> findAllByAuthor(@Param("idUser") Long idUser);
}
