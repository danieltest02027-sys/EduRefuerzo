package com.EduRefuerzo.service;

import com.EduRefuerzo.domain.Chat;
import java.util.List;
import java.util.Optional;

public interface ChatService {

    List<Chat> getChats();

    List<Chat> getChatsPorEstudiante(Long idEstudiante);

    Optional<Chat> getChat(Chat chat);

    void save(Chat chat);

    void delete(Chat chat);
}