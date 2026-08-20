package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.HorarioEstudio;
import java.util.List;
import java.util.Optional;

public interface HorarioEstudioService {

    List<HorarioEstudio> getHorarios();

    List<HorarioEstudio> getHorariosPorEstudiante(Long idEstudiante);

    Optional<HorarioEstudio> getHorario(HorarioEstudio horario);

    void save(HorarioEstudio horario);

    void delete(HorarioEstudio horario);
}