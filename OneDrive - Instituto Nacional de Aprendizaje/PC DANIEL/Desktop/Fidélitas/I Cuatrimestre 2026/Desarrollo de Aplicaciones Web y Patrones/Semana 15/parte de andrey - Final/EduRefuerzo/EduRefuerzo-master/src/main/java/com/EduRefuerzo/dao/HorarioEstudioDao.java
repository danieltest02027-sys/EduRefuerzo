package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.HorarioEstudio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioEstudioDao extends JpaRepository<HorarioEstudio, Long> {

    List<HorarioEstudio> findByEstudiante_IdEstudiante(Long idEstudiante);
}