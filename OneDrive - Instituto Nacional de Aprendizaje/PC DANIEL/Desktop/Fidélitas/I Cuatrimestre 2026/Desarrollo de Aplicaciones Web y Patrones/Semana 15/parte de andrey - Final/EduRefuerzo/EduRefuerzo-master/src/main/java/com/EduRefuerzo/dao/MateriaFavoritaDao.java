package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.MateriaFavorita;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaFavoritaDao extends JpaRepository<MateriaFavorita, Long> {

    List<MateriaFavorita> findByEstudiante_IdEstudiante(Long idEstudiante);

    boolean existsByEstudiante_IdEstudianteAndMateria_IdMateria(Long idEstudiante, Long idMateria);
}