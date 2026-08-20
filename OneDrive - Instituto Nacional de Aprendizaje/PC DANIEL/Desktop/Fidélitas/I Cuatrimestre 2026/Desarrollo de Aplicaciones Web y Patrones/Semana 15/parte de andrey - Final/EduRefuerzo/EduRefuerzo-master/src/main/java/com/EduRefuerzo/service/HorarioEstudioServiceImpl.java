package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.HorarioEstudioDao;
import com.EduRefuerzo.domain.HorarioEstudio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioEstudioServiceImpl implements HorarioEstudioService {

    @Autowired
    private HorarioEstudioDao horarioEstudioDao;

    @Override
    public List<HorarioEstudio> getHorarios() {
        return horarioEstudioDao.findAll();
    }

    @Override
    public List<HorarioEstudio> getHorariosPorEstudiante(Long idEstudiante) {
        return horarioEstudioDao.findByEstudiante_IdEstudiante(idEstudiante);
    }

    @Override
    public Optional<HorarioEstudio> getHorario(HorarioEstudio horario) {
        return horarioEstudioDao.findById(horario.getIdHorario());
    }

    @Override
    public void save(HorarioEstudio horario) {
        horarioEstudioDao.save(horario);
    }

    @Override
    public void delete(HorarioEstudio horario) {
        horarioEstudioDao.delete(horario);
    }
}