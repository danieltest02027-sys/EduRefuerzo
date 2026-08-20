package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Publicacion;
import java.util.List;

public interface PublicacionService {

    public List<Publicacion> getPublicaciones();

    public Publicacion getPublicacion(Publicacion publicacion);

    public void save(Publicacion publicacion);

    public void delete(Publicacion publicacion);
}