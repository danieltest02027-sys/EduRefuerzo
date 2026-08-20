package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.FavoritoDao;
import com.EduRefuerzo.domain.Favorito;
import com.EduRefuerzo.domain.Estudiante;
import com.EduRefuerzo.domain.Recurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritoServiceImpl implements FavoritoService {

    @Autowired
    private FavoritoDao favoritoDao;

    @Override
    public List<Favorito> getFavoritos(Long idEstudiante) {
        return favoritoDao.findByEstudiante_IdEstudiante(idEstudiante);
    }

    @Override
    public void toggleFavorito(Long idEstudiante, Long idRecurso) {

        Favorito existente = favoritoDao
                .findByEstudiante_IdEstudianteAndRecurso_IdRecurso(idEstudiante, idRecurso);

        if (existente != null) {
            favoritoDao.delete(existente);
        } else {
            Favorito fav = new Favorito();

            Estudiante est = new Estudiante();
            est.setIdEstudiante(idEstudiante);

            Recurso rec = new Recurso();
            rec.setIdRecurso(idRecurso);

            fav.setEstudiante(est);
            fav.setRecurso(rec);

            favoritoDao.save(fav);
        }
    }

    @Override
    public void delete(Favorito favorito) {
        favoritoDao.delete(favorito);
    }

    @Override
    public List<Favorito> getFavoritosPorEstudiante(Long idEstudiante) {
        return favoritoDao.findByEstudiante_IdEstudiante(idEstudiante);
    }
}
