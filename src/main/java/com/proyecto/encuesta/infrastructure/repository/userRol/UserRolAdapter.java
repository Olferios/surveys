package com.proyecto.encuesta.infrastructure.repository.userRol;

import com.proyecto.encuesta.aplication.service.userRol.IUserRolService;
import com.proyecto.encuesta.domain.entities.UserRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.encuesta.domain.entities.UserRolpk;
import java.util.List;
import java.util.Optional;

@Service
public class UserRolAdapter implements IUserRolService {

    @Autowired
    private UserRolRepository userRolRepository;

    @Override
    public Optional<UserRol> findById(UserRolpk userRolpk) {
        return userRolRepository.findById(userRolpk);
    }

    @Override
    public List<UserRol> getAll() {
        return userRolRepository.findAll();
    }

    @Override
    public UserRol save(UserRol userRol) {
        return userRolRepository.save(userRol);
    }

    @Override
    public UserRol update(UserRolpk userRolpk, UserRol userRol) {
        return userRolRepository.findById(userRolpk)
                .map(existingUserRol -> {
                    existingUserRol.setUser(userRol.getUser());
                    existingUserRol.setRol(userRol.getRol());
                    return userRolRepository.save(existingUserRol);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(UserRolpk userRolpk) {
        userRolRepository.deleteById(userRolpk);
    }


}
