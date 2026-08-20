package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.AsignacionMateria;
import java.util.List;

public interface AsignacionMateriaService {
    
    public List<AsignacionMateria> getAsignaciones();

    public AsignacionMateria getAsignacion(AsignacionMateria asignacion);

    public void save(AsignacionMateria asignacion);

    public void delete(AsignacionMateria asignacion);

    public boolean existeAsignacion(Long idEstudiante, Long idMateria);
}