package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.NotaAcademica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaAcademicaDao extends JpaRepository<NotaAcademica, Long> {

    List<NotaAcademica> findByEstudiante_IdEstudiante(Long idEstudiante);
}