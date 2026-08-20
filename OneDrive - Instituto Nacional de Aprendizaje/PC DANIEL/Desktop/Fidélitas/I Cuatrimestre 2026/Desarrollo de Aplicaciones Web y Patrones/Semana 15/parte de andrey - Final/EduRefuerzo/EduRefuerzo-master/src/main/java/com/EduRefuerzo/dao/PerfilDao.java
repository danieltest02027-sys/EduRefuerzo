package com.EduRefuerzo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EduRefuerzo.domain.Perfil;

public interface PerfilDao extends JpaRepository<Perfil, Long>{
    
}