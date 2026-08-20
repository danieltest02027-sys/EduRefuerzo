package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Materia;
import java.util.List;

public interface MateriaService {
    public List<Materia> getMaterias();
    public void save(Materia materia);
    public void delete(Materia materia);
    public Materia getMateria(Materia materia);
}