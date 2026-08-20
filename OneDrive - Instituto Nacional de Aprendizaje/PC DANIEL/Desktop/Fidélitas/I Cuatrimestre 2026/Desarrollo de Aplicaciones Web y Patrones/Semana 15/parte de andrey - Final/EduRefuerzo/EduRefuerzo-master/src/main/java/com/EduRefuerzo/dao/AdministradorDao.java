package com.EduRefuerzo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EduRefuerzo.domain.Administrador;

public interface AdministradorDao extends JpaRepository<Administrador, Long>{

}