package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Perfil;
import java.util.List;

public interface PerfilService {

    public List<Perfil> getPerfiles();

    public Perfil getPerfil(Perfil perfil);

    public void save(Perfil perfil);

    public void delete(Perfil perfil);

}