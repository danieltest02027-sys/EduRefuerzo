package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Recurso;
import java.util.List;

public interface RecursoService {
    
    public List<Recurso> getRecursos();

    public Recurso getRecurso(Recurso recurso);

    public void save(Recurso recurso);

    public void delete(Recurso recurso);
}