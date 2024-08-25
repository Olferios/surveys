package com.proyecto.encuesta.infrastructure.repository.subresponseOption;

import com.proyecto.encuesta.aplication.service.subresponseOption.ISubresponseOptionService;
import com.proyecto.encuesta.domain.entities.SubresponseOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubresponseOptionAdapter implements ISubresponseOptionService {

    @Autowired
    private SubresponseOptionRepository subresponseOptionRepository;

    @Override
    public Optional<SubresponseOption> findById(Long id) {
        return subresponseOptionRepository.findById(id);
    }

    @Override
    public List<SubresponseOption> getAll() {
        return subresponseOptionRepository.findAll();
    }

    @Override
    public SubresponseOption save(SubresponseOption subresponseOption) {
        return subresponseOptionRepository.save(subresponseOption);
    }

    @Override
    public SubresponseOption update(Long id, SubresponseOption subresponseOption) {
        return subresponseOptionRepository.findById(id)
                .map(existingSubresponseOption -> {
                    existingSubresponseOption.setSubresponse_number(subresponseOption.getSubresponse_number());
                    existingSubresponseOption.setComponent_html(subresponseOption.getComponent_html());
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
