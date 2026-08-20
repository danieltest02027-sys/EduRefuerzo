package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.NotaAcademica;
import java.util.List;
import java.util.Optional;

public interface NotaAcademicaService {

    List<NotaAcademica> getNotas();

    List<NotaAcademica> getNotasPorEstudiante(Long idEstudiante);

    Optional<NotaAcademica> getNota(NotaAcademica notaAcademica);

    void save(NotaAcademica notaAcademica);

    void delete(NotaAcademica notaAcademica);
}