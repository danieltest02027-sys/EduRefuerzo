package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.MensajeDao;
import com.EduRefuerzo.domain.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MensajeServiceImpl implements MensajeService {

    @Autowired
    private MensajeDao mensajeDao;

    @Override
    public List<Mensaje> getMensajes() {
        return mensajeDao.findAll();
    }

    @Override
    public List<Mensaje> getMensajesPorChat(Long idChat) {
        return mensajeDao.findByChat_IdChat(idChat);
    }

    @Override
    public Optional<Mensaje> getMensaje(Mensaje mensaje) {
        return mensajeDao.findById(mensaje.getIdMensaje());
    }

    @Override
    public void save(Mensaje mensaje) {
        mensajeDao.save(mensaje);
    }

    @Override
    public void delete(Mensaje mensaje) {
        mensajeDao.delete(mensaje);
    }

    @Override
    @Transactional
    public void deleteMensajesPorChat(Long idChat) {
        mensajeDao.deleteByChat_IdChat(idChat);
    }
}
