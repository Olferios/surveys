package com.proyecto.encuesta.infrastructure.repository.rol;

import com.proyecto.encuesta.aplication.service.rol.IRolService;
import com.proyecto.encuesta.domain.entities.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolAdapter implements IRolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Long id, Rol rol) {
        return rolRepository.findById(id)
                .map(existingRol -> {
                    existingRol.setName(rol.getName());
                    return rolRepository.save(existingRol);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }
}
