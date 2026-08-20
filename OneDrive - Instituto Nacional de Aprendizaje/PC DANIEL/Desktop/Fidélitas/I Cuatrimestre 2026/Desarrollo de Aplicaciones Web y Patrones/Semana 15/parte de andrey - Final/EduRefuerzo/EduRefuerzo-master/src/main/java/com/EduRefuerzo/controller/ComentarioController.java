package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Comentario;
import com.EduRefuerzo.domain.Recurso;
import com.EduRefuerzo.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // Listar
    @GetMapping("/listado/{idRecurso}")
    public String listado(@PathVariable Long idRecurso, Model model) {
        var comentarios = comentarioService.getComentariosPorRecurso(idRecurso);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("idRecurso", idRecurso);
        return "listadoComentarios";
    }

    // Nuevo
    @GetMapping("/nuevo/{idRecurso}")
    public String nuevo(Comentario comentario, @PathVariable Long idRecurso, Model model) {
        model.addAttribute("idRecurso", idRecurso);
        return "formularioComentario";
    }

    // Guardar
    @PostMapping("/guardar")
    public String guardar(Comentario comentario, @RequestParam Long idRecurso) {

        Recurso r = new Recurso();
        r.setIdRecurso(idRecurso);

        comentario.setRecurso(r);

        comentarioService.save(comentario);

        return "redirect:/comentario/listado/" + idRecurso;
    }

    // Eliminar
    @GetMapping("/eliminar/{idComentario}/{idRecurso}")
    public String eliminar(Comentario comentario, @PathVariable Long idRecurso) {
        comentarioService.delete(comentario);
        return "redirect:/comentario/listado/" + idRecurso;
    }

    // Modificar 
    @GetMapping("/modificar/{idComentario}/{idRecurso}")
    public String modificar(Comentario comentario, @PathVariable Long idRecurso, Model model) {
        comentario = comentarioService.getComentario(comentario);
        model.addAttribute("comentario", comentario);
        model.addAttribute("idRecurso", idRecurso);
        return "formularioComentario";
    }
}