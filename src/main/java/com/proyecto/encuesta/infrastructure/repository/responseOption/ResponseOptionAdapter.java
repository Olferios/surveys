package com.proyecto.encuesta.infrastructure.repository.responseOption;

import com.proyecto.encuesta.aplication.service.responseOption.IResponseOptionService;
import com.proyecto.encuesta.domain.entities.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseOptionAdapter implements IResponseOptionService {

    @Autowired
    private ResponseOptionRepository responseOptionRepository;

    @Override
    public Optional<Options> findById(Long id) {
        return responseOptionRepository.findById(id);
    }

    @Override
    public List<Options> getAll() {
        return responseOptionRepository.findAll();
    }

    @Override
    public Options save(Options responseOption) {
        return responseOptionRepository.save(responseOption);
    }

    @Override
    public Options update(Long id, Options responseOption) {
        return responseOptionRepository.findById(id)
                .map(existingResponseOption -> {
                    existingResponseOption.setOptiontext(responseOption.getOptiontext());
                    return responseOptionRepository.save(existingResponseOption);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        responseOptionRepository.deleteById(id);
    }
}
