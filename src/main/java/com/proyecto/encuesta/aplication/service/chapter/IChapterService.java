package com.proyecto.encuesta.aplication.service.chapter;

import java.util.List;
import java.util.Optional;

import com.proyecto.encuesta.domain.entities.*;

public interface IChapterService {
    Optional<Chapter> findById(Long id);
    List<Chapter> getAll();
    Chapter save(Chapter chapter);
    Chapter update(Long id, Chapter chapter);
    void deleteById(Long id);
}
