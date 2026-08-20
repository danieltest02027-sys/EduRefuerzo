package com.EduRefuerzo.service;


import com.EduRefuerzo.domain.Administrador;
import java.util.List;

public interface AdministradorService {

    public List<Administrador> getAdministradores();

    public Administrador getAdministrador(Administrador administrador);

    public void save(Administrador administrador);

    public void delete(Administrador administrador);
}