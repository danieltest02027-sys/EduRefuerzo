package com.EduRefuerzo.service;


import com.EduRefuerzo.dao.AdministradorDao;
import com.EduRefuerzo.domain.Administrador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorDao administradorDao;

    @Override
    public List<Administrador> getAdministradores() {
        return administradorDao.findAll();
    }

    @Override
    public Administrador getAdministrador(Administrador administrador) {
        return administradorDao.findById(administrador.getIdAdministrador()).orElse(null);
    }

    @Override
    public void save(Administrador administrador) {
        administradorDao.save(administrador);
    }

    @Override
    public void delete(Administrador administrador) {
        administradorDao.delete(administrador);
    }
}