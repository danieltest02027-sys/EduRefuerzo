package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaDao extends JpaRepository<Materia, Long> {
}