package com.EduRefuerzo.service;

import com.EduRefuerzo.dao.ChatDao;
import com.EduRefuerzo.domain.Chat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatDao chatDao;

    @Override
    public List<Chat> getChats() {
        return chatDao.findAll();
    }

    @Override
    public List<Chat> getChatsPorEstudiante(Long idEstudiante) {
        return chatDao.findByUsuarioOrigen_IdEstudianteOrUsuarioDestino_IdEstudiante(idEstudiante, idEstudiante);
    }

    @Override
    public Optional<Chat> getChat(Chat chat) {
        return chatDao.findById(chat.getIdChat());
    }

    @Override
    public void save(Chat chat) {
        chatDao.save(chat);
    }

    @Override
    public void delete(Chat chat) {
        chatDao.delete(chat);
    }
}