package com.EduRefuerzo.dao;

import com.EduRefuerzo.domain.Mensaje;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeDao extends JpaRepository<Mensaje, Long> {

    List<Mensaje> findByChat_IdChat(Long idChat);

    void deleteByChat_IdChat(Long idChat);
}