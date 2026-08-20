package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.Chat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatDao extends JpaRepository<Chat, Long> {

    List<Chat> findByUsuarioOrigen_IdEstudianteOrUsuarioDestino_IdEstudiante(Long idOrigen, Long idDestino);
}