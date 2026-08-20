package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.Favorito;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritoDao extends JpaRepository<Favorito, Long> {

    List<Favorito> findByEstudiante_IdEstudiante(Long idEstudiante);

    Favorito findByEstudiante_IdEstudianteAndRecurso_IdRecurso(Long idEstudiante, Long idRecurso);
}