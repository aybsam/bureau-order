package com.lismart.smartregie.service;

import com.lismart.smartregie.domain.User;
import com.lismart.smartregie.exception.EmailExistsException;
import com.lismart.smartregie.repository.UserRepository;
import com.lismart.smartregie.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(Email email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void save(User user) throws EmailExistsException {

        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // TODO : On ajouterPaiements email updated already exists
        if (user.getId() == null && emailExists(user.getEmail())) {
            throw new EmailExistsException(user.getEmail().toString());
        }

        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    private boolean emailExists(Email email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }
}
