package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.MateriaDao;
import com.EduRefuerzo.domain.Materia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaDao materiaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Materia> getMaterias() {
        return (List<Materia>) materiaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Materia materia) {
        materiaDao.save(materia);
    }

    @Override
    @Transactional
    public void delete(Materia materia) {
        materiaDao.delete(materia);
    }

    @Override
    @Transactional(readOnly = true)
    public Materia getMateria(Materia materia) {
        return materiaDao.findById(materia.getIdMateria()).orElse(null);
    }
}