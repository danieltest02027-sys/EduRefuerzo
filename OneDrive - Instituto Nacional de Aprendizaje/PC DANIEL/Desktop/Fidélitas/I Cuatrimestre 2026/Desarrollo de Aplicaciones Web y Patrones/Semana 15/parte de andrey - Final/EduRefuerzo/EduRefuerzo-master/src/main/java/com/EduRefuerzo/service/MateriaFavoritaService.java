package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.MateriaFavorita;
import java.util.List;
import java.util.Optional;

public interface MateriaFavoritaService {

    List<MateriaFavorita> getMateriasFavoritas();

    List<MateriaFavorita> getMateriasFavoritasPorEstudiante(Long idEstudiante);

    Optional<MateriaFavorita> getMateriaFavorita(MateriaFavorita materiaFavorita);

    boolean existsByEstudianteAndMateria(Long idEstudiante, Long idMateria);

    void save(MateriaFavorita materiaFavorita);

    void delete(MateriaFavorita materiaFavorita);
}