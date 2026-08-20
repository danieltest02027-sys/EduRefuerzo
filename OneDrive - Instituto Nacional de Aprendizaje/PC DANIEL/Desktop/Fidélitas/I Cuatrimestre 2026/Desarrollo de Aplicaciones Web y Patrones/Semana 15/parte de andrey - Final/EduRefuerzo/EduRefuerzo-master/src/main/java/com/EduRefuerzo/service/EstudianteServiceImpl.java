package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.EstudianteDao;
import com.EduRefuerzo.domain.Estudiante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteDao estudianteDao;

    @Override
    public List<Estudiante> getEstudiantes() {
        return estudianteDao.findAll();
    }

    @Override
    public Estudiante getEstudiante(Estudiante estudiante) {
        return estudianteDao.findById(estudiante.getIdEstudiante()).orElse(null);
    }

    @Override
    public void save(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Override
    public void delete(Estudiante estudiante) {
        estudianteDao.delete(estudiante);
    }

}