package com.proyecto.encuesta.infrastructure.repository.subresponseOption;

import com.proyecto.encuesta.aplication.service.subresponseOption.ISubresponseOptionService;
import com.proyecto.encuesta.domain.entities.OptionQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubresponseOptionAdapter implements ISubresponseOptionService {

    @Autowired
    private SubresponseOptionRepository subresponseOptionRepository;

    @Override
    public Optional<OptionQuestion> findById(Long id) {
        return subresponseOptionRepository.findById(id);
    }

    @Override
    public List<OptionQuestion> getAll() {
        return subresponseOptionRepository.findAll();
    }

    @Override
    public OptionQuestion save(OptionQuestion subresponseOption) {
        return subresponseOptionRepository.save(subresponseOption);
    }

    @Override
    public OptionQuestion update(Long id, OptionQuestion subresponseOption) {
        return subresponseOptionRepository.findById(id)
                .map(existingSubresponseOption -> {
                    existingSubresponseOption.setSubresponse_number(subresponseOption.getSubresponse_number());
                    existingSubresponseOption.setSubresponse_number(subresponseOption.getSubresponse_number());
                    return subresponseOptionRepository.save(existingSubresponseOption);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        subresponseOptionRepository.deleteById(id);
    }
}
