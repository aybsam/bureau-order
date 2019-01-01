package com.lismart.smartregie.repository;

import com.lismart.smartregie.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    @Override
    void delete(Role role);
}
