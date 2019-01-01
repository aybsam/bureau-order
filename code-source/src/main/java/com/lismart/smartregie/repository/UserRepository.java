package com.lismart.smartregie.repository;

import com.lismart.smartregie.domain.User;
import com.lismart.smartregie.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(Email email);
}
