package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Mensaje;
import java.util.List;
import java.util.Optional;

public interface MensajeService {

    List<Mensaje> getMensajes();

    List<Mensaje> getMensajesPorChat(Long idChat);

    Optional<Mensaje> getMensaje(Mensaje mensaje);

    void save(Mensaje mensaje);

    void delete(Mensaje mensaje);

    void deleteMensajesPorChat(Long idChat);
}