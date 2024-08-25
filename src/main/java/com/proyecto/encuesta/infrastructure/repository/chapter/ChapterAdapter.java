package com.proyecto.encuesta.infrastructure.repository.chapter;

import com.proyecto.encuesta.aplication.service.chapter.IChapterService;
import com.proyecto.encuesta.domain.entities.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterAdapter implements IChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public Optional<Chapter> findById(Long id) {
        return chapterRepository.findById(id);
    }

    @Override
    public List<Chapter> getAll() {
        return chapterRepository.findAll();
    }

    @Override
    public Chapter save(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Override
    public Chapter update(Long id, Chapter chapter) {
        return chapterRepository.findById(id)
                .map(existingChapter -> {
                    existingChapter.setChapter_number(chapter.getChapter_number());
                    existingChapter.setChapter_number(chapter.getChapter_title());
                    return chapterRepository.save(existingChapter);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        chapterRepository.deleteById(id);
    }
}
