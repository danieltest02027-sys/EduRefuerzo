package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaDao extends JpaRepository<Tema, Long> {
}