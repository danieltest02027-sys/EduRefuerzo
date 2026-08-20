package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionDao extends JpaRepository<Publicacion, Long> {
}