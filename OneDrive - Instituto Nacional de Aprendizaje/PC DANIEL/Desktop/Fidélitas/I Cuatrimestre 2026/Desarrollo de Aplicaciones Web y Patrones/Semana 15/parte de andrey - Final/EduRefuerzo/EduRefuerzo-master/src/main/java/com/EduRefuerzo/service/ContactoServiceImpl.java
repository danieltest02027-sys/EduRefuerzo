package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.ContactoDao;
import com.EduRefuerzo.domain.Contacto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    private ContactoDao contactoDao;

    @Override
    public List<Contacto> getContactos() {
        return contactoDao.findAll();
    }

    @Override
    public Contacto getContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getIdContacto()).orElse(null);
    }

    @Override
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

    @Override
    public void delete(Contacto contacto) {
        contactoDao.delete(contacto);
    }
}