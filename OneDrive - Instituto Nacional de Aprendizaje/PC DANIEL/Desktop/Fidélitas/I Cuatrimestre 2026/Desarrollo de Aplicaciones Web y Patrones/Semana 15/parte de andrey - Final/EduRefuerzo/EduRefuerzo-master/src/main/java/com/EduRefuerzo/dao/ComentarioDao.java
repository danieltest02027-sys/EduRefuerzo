package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.Comentario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioDao extends JpaRepository<Comentario, Long> {

    List<Comentario> findByRecurso_IdRecurso(Long idRecurso);

}