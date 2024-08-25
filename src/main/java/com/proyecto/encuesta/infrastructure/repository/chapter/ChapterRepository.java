package com.proyecto.encuesta.infrastructure.repository.chapter;

import com.proyecto.encuesta.domain.entities.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
