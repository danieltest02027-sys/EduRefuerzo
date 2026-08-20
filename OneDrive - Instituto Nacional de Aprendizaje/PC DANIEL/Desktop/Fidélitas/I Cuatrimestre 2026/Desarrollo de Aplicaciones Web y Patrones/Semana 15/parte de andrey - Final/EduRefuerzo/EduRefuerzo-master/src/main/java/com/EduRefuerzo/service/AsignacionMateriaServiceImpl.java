package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.AsignacionMateriaDao;
import com.EduRefuerzo.domain.AsignacionMateria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionMateriaServiceImpl implements AsignacionMateriaService {

    @Autowired
    private AsignacionMateriaDao asignacionMateriaDao;

    @Override
    public List<AsignacionMateria> getAsignaciones() {
        return asignacionMateriaDao.findAll();
    }

    @Override
    public AsignacionMateria getAsignacion(AsignacionMateria asignacion) {
        return asignacionMateriaDao.findById(asignacion.getIdAsignacion()).orElse(null);
    }

    @Override
    public void save(AsignacionMateria asignacion) {
        asignacionMateriaDao.save(asignacion);
    }

    @Override
    public void delete(AsignacionMateria asignacion) {
        asignacionMateriaDao.delete(asignacion);
    }

    @Override
    public boolean existeAsignacion(Long idEstudiante, Long idMateria) {
        return asignacionMateriaDao
                .findByEstudiante_IdEstudianteAndMateria_IdMateria(idEstudiante, idMateria) != null;
    }
}