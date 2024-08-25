package com.proyecto.encuesta.infrastructure.repository.user;

import com.proyecto.encuesta.aplication.service.user.IUserService;
import com.proyecto.encuesta.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAdapter implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setPassword(user.getPassword());
              
                    return userRepository.save(existingUser);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
