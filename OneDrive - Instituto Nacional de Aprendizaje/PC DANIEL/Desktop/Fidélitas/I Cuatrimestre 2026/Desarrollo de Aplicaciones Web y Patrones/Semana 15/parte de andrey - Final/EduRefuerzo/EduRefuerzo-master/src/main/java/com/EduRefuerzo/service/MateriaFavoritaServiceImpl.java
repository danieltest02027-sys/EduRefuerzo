package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.MateriaFavoritaDao;
import com.EduRefuerzo.domain.MateriaFavorita;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaFavoritaServiceImpl implements MateriaFavoritaService {

    @Autowired
    private MateriaFavoritaDao materiaFavoritaDao;

    @Override
    public List<MateriaFavorita> getMateriasFavoritas() {
        return materiaFavoritaDao.findAll();
    }

    @Override
    public List<MateriaFavorita> getMateriasFavoritasPorEstudiante(Long idEstudiante) {
        return materiaFavoritaDao.findByEstudiante_IdEstudiante(idEstudiante);
    }

    @Override
    public Optional<MateriaFavorita> getMateriaFavorita(MateriaFavorita materiaFavorita) {
        return materiaFavoritaDao.findById(materiaFavorita.getIdFavorita());
    }

    @Override
    public boolean existsByEstudianteAndMateria(Long idEstudiante, Long idMateria) {
        return materiaFavoritaDao.existsByEstudiante_IdEstudianteAndMateria_IdMateria(idEstudiante, idMateria);
    }

    @Override
    public void save(MateriaFavorita materiaFavorita) {
        materiaFavoritaDao.save(materiaFavorita);
    }

    @Override
    public void delete(MateriaFavorita materiaFavorita) {
        materiaFavoritaDao.delete(materiaFavorita);
    }
}
