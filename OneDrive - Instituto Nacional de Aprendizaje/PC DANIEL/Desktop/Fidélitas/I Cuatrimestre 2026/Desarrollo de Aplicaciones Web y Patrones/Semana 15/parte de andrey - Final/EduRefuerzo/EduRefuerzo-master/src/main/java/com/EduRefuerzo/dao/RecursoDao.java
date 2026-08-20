package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoDao extends JpaRepository<Recurso, Long> {
}