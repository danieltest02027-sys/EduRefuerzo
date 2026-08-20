package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Tema;
import com.EduRefuerzo.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    private TemaService temaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var temas = temaService.getTemas();
        model.addAttribute("temas", temas);
        return "listadoTemas"; // Nombre del HTML en templates
    }

    @GetMapping("/nuevo")
    public String temaNuevo(Tema tema) {
        return "formularioTema"; // Nombre del HTML en templates
    }

    @PostMapping("/guardar")
    public String temaGuardar(Tema tema) {
        temaService.save(tema);
        return "redirect:/tema/listado";
    }

    @GetMapping("/eliminar/{idTema}")
    public String temaEliminar(Tema tema) {
        temaService.delete(tema);
        return "redirect:/tema/listado";
    }

    @GetMapping("/modificar/{idTema}")
    public String temaModificar(Tema tema, Model model) {
        tema = temaService.getTema(tema);
        model.addAttribute("tema", tema);
        return "formularioTema"; // Nombre del HTML en templates
    }
}