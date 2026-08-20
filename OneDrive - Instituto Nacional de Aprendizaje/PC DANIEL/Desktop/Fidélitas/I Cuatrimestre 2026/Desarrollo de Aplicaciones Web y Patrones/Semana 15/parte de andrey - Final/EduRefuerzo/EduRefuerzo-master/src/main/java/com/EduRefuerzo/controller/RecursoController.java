package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Recurso;
import com.EduRefuerzo.service.RecursoService;
import com.EduRefuerzo.service.TemaService;
import com.EduRefuerzo.service.FavoritoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/recurso")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @Autowired
    private TemaService temaService;

    @Autowired
    private FavoritoService favoritoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var recursos = recursoService.getRecursos();

        Long idEstudiante = 1L; 

        var favoritos = favoritoService.getFavoritosPorEstudiante(idEstudiante);

        var idsFavoritos = favoritos.stream()
                .map(f -> f.getRecurso().getIdRecurso())
                .toList();

        model.addAttribute("recursos", recursos);
        model.addAttribute("idsFavoritos", idsFavoritos);

        return "listadoRecursos";
    }

    @GetMapping("/nuevo")
    public String recursoNuevo(Recurso recurso, Model model) {
        var temas = temaService.getTemas();
        model.addAttribute("temas", temas);
        return "formularioRecurso";
    }

    @PostMapping("/guardar")
    public String recursoGuardar(Recurso recurso, RedirectAttributes redirectAttributes) {
        boolean esNuevo = (recurso.getIdRecurso() == null);

        recursoService.save(recurso);

        if (esNuevo) {
            redirectAttributes.addFlashAttribute("mensajeExito", "Recurso creado correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("mensajeExito", "Recurso actualizado correctamente.");
        }

        return "redirect:/recurso/listado";
    }

    @GetMapping("/eliminar/{idRecurso}")
    public String recursoEliminar(Recurso recurso, RedirectAttributes redirectAttributes) {
        recursoService.delete(recurso);
        redirectAttributes.addFlashAttribute("mensajeExito", "Recurso eliminado correctamente.");
        return "redirect:/recurso/listado";
    }

    @GetMapping("/modificar/{idRecurso}")
    public String recursoModificar(Recurso recurso, Model model) {
        recurso = recursoService.getRecurso(recurso);
        var temas = temaService.getTemas();

        model.addAttribute("recurso", recurso);
        model.addAttribute("temas", temas);

        return "formularioRecurso";
    }
}