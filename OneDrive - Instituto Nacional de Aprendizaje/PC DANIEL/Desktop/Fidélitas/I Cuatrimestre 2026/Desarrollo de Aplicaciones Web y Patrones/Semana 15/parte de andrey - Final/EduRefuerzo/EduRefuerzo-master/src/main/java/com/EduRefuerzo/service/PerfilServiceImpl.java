package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.PerfilDao;
import com.EduRefuerzo.domain.Perfil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    private PerfilDao perfilDao;

    @Override
    public List<Perfil> getPerfiles() {
        return perfilDao.findAll();
    }

    @Override
    public Perfil getPerfil(Perfil perfil) {
        return perfilDao.findById(perfil.getIdPerfil()).orElse(null);
    }

    @Override
    public void save(Perfil perfil) {
        perfilDao.save(perfil);
    }

    @Override
    public void delete(Perfil perfil) {
        perfilDao.delete(perfil);
    }

}