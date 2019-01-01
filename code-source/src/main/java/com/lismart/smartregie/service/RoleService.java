package com.lismart.smartregie.service;

import com.lismart.smartregie.domain.Role;

public interface RoleService {
    Role findByName(String name);
}
