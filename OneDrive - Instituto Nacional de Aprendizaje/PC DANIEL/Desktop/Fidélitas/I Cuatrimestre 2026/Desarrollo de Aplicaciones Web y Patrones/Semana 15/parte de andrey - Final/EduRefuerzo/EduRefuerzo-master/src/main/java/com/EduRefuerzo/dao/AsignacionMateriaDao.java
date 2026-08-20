package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.AsignacionMateria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionMateriaDao extends JpaRepository<AsignacionMateria, Long> {

    AsignacionMateria findByEstudiante_IdEstudianteAndMateria_IdMateria(Long idEstudiante, Long idMateria);
}