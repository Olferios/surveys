package com.proyecto.encuesta.infrastructure.repository.responseOption;

import com.proyecto.encuesta.aplication.service.responseOption.IResponseOptionService;
import com.proyecto.encuesta.domain.entities.ResponseOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseOptionAdapter implements IResponseOptionService {

    @Autowired
    private ResponseOptionRepository responseOptionRepository;

    @Override
    public Optional<ResponseOption> findById(Long id) {
        return responseOptionRepository.findById(id);
    }

    @Override
    public List<ResponseOption> getAll() {
        return responseOptionRepository.findAll();
    }

    @Override
    public ResponseOption save(ResponseOption responseOption) {
        return responseOptionRepository.save(responseOption);
    }

    @Override
    public ResponseOption update(Long id, ResponseOption responseOption) {
        return responseOptionRepository.findById(id)
                .map(existingResponseOption -> {
                    existingResponseOption.setOption_value(responseOption.getOption_value());
                    existingResponseOption.setTypecomponenthtml(responseOption.getTypecomponenthtml());
                    existingResponseOption.setComment_response(responseOption.getComment_response());
                    existingResponseOption.setOption_text(responseOption.getOption_text());
                    return responseOptionRepository.save(existingResponseOption);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        responseOptionRepository.deleteById(id);
    }
}
