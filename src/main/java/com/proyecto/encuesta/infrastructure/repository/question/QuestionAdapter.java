package com.proyecto.encuesta.infrastructure.repository.question;

import com.proyecto.encuesta.aplication.service.question.IQuestionService;
import com.proyecto.encuesta.domain.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionAdapter implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question update(Long id, Question question) {
        return questionRepository.findById(id)
                .map(existingQuestion -> {
                    existingQuestion.setQuestion_number(question.getQuestion_number());
                    existingQuestion.setResponse_type(question.getResponse_type());
                    existingQuestion.setComment_question(question.getComment_question());
                    existingQuestion.setQuestion_text(question.getQuestion_text());
                    return questionRepository.save(existingQuestion);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}
