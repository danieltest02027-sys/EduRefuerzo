package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Comentario;
import java.util.List;

public interface ComentarioService {

    public List<Comentario> getComentarios();

    public List<Comentario> getComentariosPorRecurso(Long idRecurso);

    public Comentario getComentario(Comentario comentario);

    public void save(Comentario comentario);

    public void delete(Comentario comentario);
}