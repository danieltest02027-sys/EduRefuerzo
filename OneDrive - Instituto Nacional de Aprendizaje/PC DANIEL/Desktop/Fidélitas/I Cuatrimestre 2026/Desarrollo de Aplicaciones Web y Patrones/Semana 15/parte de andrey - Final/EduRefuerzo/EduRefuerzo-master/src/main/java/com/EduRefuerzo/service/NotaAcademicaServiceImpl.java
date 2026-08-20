package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.NotaAcademicaDao;
import com.EduRefuerzo.domain.NotaAcademica;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaAcademicaServiceImpl implements NotaAcademicaService {

    @Autowired
    private NotaAcademicaDao notaAcademicaDao;

    @Override
    public List<NotaAcademica> getNotas() {
        return notaAcademicaDao.findAll();
    }

    @Override
    public List<NotaAcademica> getNotasPorEstudiante(Long idEstudiante) {
        return notaAcademicaDao.findByEstudiante_IdEstudiante(idEstudiante);
    }

    @Override
    public Optional<NotaAcademica> getNota(NotaAcademica notaAcademica) {
        return notaAcademicaDao.findById(notaAcademica.getIdNota());
    }

    @Override
    public void save(NotaAcademica notaAcademica) {
        notaAcademicaDao.save(notaAcademica);
    }

    @Override
    public void delete(NotaAcademica notaAcademica) {
        notaAcademicaDao.delete(notaAcademica);
    }
}