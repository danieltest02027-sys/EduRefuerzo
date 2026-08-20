package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.RecursoDao;
import com.EduRefuerzo.domain.Recurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecursoServiceImpl implements RecursoService {

    @Autowired
    private RecursoDao recursoDao;

    @Override
    public List<Recurso> getRecursos() {
        return recursoDao.findAll();
    }

    @Override
    public Recurso getRecurso(Recurso recurso) {
        return recursoDao.findById(recurso.getIdRecurso()).orElse(null);
    }

    @Override
    public void save(Recurso recurso) {
        recursoDao.save(recurso);
    }

    @Override
    public void delete(Recurso recurso) {
        recursoDao.delete(recurso);
    }
}