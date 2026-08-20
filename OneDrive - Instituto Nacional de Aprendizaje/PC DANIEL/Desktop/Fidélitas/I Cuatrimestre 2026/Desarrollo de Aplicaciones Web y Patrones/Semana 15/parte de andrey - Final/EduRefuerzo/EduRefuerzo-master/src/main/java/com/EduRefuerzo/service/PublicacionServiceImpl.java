package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.PublicacionDao;
import com.EduRefuerzo.domain.Publicacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    private PublicacionDao publicacionDao;

    @Override
    public List<Publicacion> getPublicaciones() {
        return publicacionDao.findAll();
    }

    @Override
    public Publicacion getPublicacion(Publicacion publicacion) {
        return publicacionDao.findById(publicacion.getIdPublicacion()).orElse(null);
    }

    @Override
    public void save(Publicacion publicacion) {
        publicacionDao.save(publicacion);
    }

    @Override
    public void delete(Publicacion publicacion) {
        publicacionDao.delete(publicacion);
    }
}