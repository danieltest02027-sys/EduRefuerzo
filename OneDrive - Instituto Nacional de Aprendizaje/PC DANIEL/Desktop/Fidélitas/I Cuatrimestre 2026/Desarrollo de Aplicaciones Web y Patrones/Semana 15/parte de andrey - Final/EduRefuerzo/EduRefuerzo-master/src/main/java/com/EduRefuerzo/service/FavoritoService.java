package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Favorito;
import java.util.List;
    
public interface FavoritoService {

    List<Favorito> getFavoritos(Long idEstudiante);

    
    List<Favorito> getFavoritosPorEstudiante(Long idEstudiante);
    
    void toggleFavorito(Long idEstudiante, Long idRecurso);

    void delete(Favorito favorito);
}