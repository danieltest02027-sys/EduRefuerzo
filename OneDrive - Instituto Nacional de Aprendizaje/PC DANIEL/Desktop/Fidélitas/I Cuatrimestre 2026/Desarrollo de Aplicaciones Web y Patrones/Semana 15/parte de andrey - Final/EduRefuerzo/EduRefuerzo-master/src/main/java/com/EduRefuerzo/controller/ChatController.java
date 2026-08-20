package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Chat;
import com.EduRefuerzo.domain.Estudiante;
import com.EduRefuerzo.domain.Mensaje;
import com.EduRefuerzo.service.ChatService;
import com.EduRefuerzo.service.EstudianteService;
import com.EduRefuerzo.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private MensajeService mensajeService;

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var chats = chatService.getChats();
        model.addAttribute("chats", chats);
        return "listadoChats";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        Chat chat = new Chat();
        Mensaje mensaje = new Mensaje();

        var estudiantes = estudianteService.getEstudiantes();

        model.addAttribute("chat", chat);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("estudiantes", estudiantes);

        return "formularioChat";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam("idOrigen") Long idOrigen,
            @RequestParam("idDestino") Long idDestino,
            @RequestParam("contenidoInicial") String contenidoInicial,
            @RequestParam("estado") String estado) {

        Estudiante origen = new Estudiante();
        origen.setIdEstudiante(idOrigen);

        Estudiante destino = new Estudiante();
        destino.setIdEstudiante(idDestino);

        Chat chat = new Chat();
        chat.setUsuarioOrigen(origen);
        chat.setUsuarioDestino(destino);
        chat.setEstado(estado);

        chatService.save(chat);

        if (contenidoInicial != null && !contenidoInicial.isBlank()) {
            Mensaje mensaje = new Mensaje();
            mensaje.setChat(chat);
            mensaje.setEstudiante(origen);
            mensaje.setContenido(contenidoInicial);
            mensaje.setEstado("Activo");
            mensajeService.save(mensaje);
        }

        return "redirect:/chat/listado";
    }

    @GetMapping("/ver/{idChat}")
    public String ver(Chat chat, Model model) {
        chat = chatService.getChat(chat).orElse(null);

        if (chat == null) {
            return "redirect:/chat/listado";
        }

        var mensajes = mensajeService.getMensajesPorChat(chat.getIdChat());

        model.addAttribute("chat", chat);
        model.addAttribute("mensajes", mensajes);

        return "verChat";
    }

    @PostMapping("/guardarMensaje")
    public String guardarMensaje(@RequestParam("idChat") Long idChat,
            @RequestParam("idEstudiante") Long idEstudiante,
            @RequestParam("contenido") String contenido,
            @RequestParam("estado") String estado) {

        Chat chat = new Chat();
        chat.setIdChat(idChat);

        Estudiante estudiante = new Estudiante();
        estudiante.setIdEstudiante(idEstudiante);

        Mensaje mensaje = new Mensaje();
        mensaje.setChat(chat);
        mensaje.setEstudiante(estudiante);
        mensaje.setContenido(contenido);
        mensaje.setEstado(estado);

        mensajeService.save(mensaje);

        return "redirect:/chat/ver/" + idChat;
    }

    @GetMapping("/modificarMensaje/{idMensaje}/{idChat}")
    public String modificarMensaje(@PathVariable Long idMensaje,
            @PathVariable Long idChat,
            Model model) {

        Chat chat = new Chat();
        chat.setIdChat(idChat);
        chat = chatService.getChat(chat).orElse(null);

        if (chat == null) {
            return "redirect:/chat/listado";
        }

        Mensaje mensaje = new Mensaje();
        mensaje.setIdMensaje(idMensaje);
        mensaje = mensajeService.getMensaje(mensaje).orElse(null);

        if (mensaje == null) {
            return "redirect:/chat/ver/" + idChat;
        }

        var mensajes = mensajeService.getMensajesPorChat(idChat);

        model.addAttribute("chat", chat);
        model.addAttribute("mensajes", mensajes);
        model.addAttribute("mensajeEditar", mensaje);

        return "verChat";
    }

    @PostMapping("/actualizarMensaje")
    public String actualizarMensaje(@RequestParam("idMensaje") Long idMensaje,
            @RequestParam("idChat") Long idChat,
            @RequestParam("idEstudiante") Long idEstudiante,
            @RequestParam("contenido") String contenido,
            @RequestParam("estado") String estado) {

        Mensaje mensajeRef = new Mensaje();
        mensajeRef.setIdMensaje(idMensaje);

        Mensaje mensaje = mensajeService.getMensaje(mensajeRef).orElse(null);

        if (mensaje == null) {
            return "redirect:/chat/ver/" + idChat;
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setIdEstudiante(idEstudiante);

        mensaje.setEstudiante(estudiante);
        mensaje.setContenido(contenido);
        mensaje.setEstado(estado);

        mensajeService.save(mensaje);

        return "redirect:/chat/ver/" + idChat;
    }

    @GetMapping("/eliminar/{idChat}")
    public String eliminar(Chat chat) {
        mensajeService.deleteMensajesPorChat(chat.getIdChat());
        chatService.delete(chat);
        return "redirect:/chat/listado";
    }

    @GetMapping("/eliminarMensaje/{idMensaje}/{idChat}")
    public String eliminarMensaje(Mensaje mensaje, @PathVariable Long idChat) {
        mensajeService.delete(mensaje);
        return "redirect:/chat/ver/" + idChat;
    }

    @GetMapping("/modificar/{idChat}")
    public String modificar(Chat chat, Model model) {
        chat = chatService.getChat(chat).orElse(null);

        if (chat == null) {
            return "redirect:/chat/listado";
        }

        var estudiantes = estudianteService.getEstudiantes();

        model.addAttribute("chat", chat);
        model.addAttribute("estudiantes", estudiantes);

        return "formularioChat";
    }
}
