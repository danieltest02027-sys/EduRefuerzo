package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.ComentarioDao;
import com.EduRefuerzo.domain.Comentario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioDao comentarioDao;

    @Override
    public List<Comentario> getComentarios() {
        return comentarioDao.findAll();
    }

    @Override
    public List<Comentario> getComentariosPorRecurso(Long idRecurso) {
        return comentarioDao.findByRecurso_IdRecurso(idRecurso);
    }

    @Override
    public Comentario getComentario(Comentario comentario) {
        return comentarioDao.findById(comentario.getIdComentario()).orElse(null);
    }

    @Override
    public void save(Comentario comentario) {
        comentarioDao.save(comentario);
    }

    @Override
    public void delete(Comentario comentario) {
        comentarioDao.delete(comentario);
    }
}