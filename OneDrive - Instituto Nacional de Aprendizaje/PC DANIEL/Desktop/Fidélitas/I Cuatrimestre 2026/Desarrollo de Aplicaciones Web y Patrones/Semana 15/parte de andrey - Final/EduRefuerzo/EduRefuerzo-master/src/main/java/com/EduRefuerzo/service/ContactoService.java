package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Contacto;
import java.util.List;

public interface ContactoService {

    public List<Contacto> getContactos();

    public Contacto getContacto(Contacto contacto);

    public void save(Contacto contacto);

    public void delete(Contacto contacto);
}