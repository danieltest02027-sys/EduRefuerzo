package com.EduRefuerzo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EduRefuerzo.domain.Estudiante;

public interface EstudianteDao extends JpaRepository<Estudiante, Long>{
    
}