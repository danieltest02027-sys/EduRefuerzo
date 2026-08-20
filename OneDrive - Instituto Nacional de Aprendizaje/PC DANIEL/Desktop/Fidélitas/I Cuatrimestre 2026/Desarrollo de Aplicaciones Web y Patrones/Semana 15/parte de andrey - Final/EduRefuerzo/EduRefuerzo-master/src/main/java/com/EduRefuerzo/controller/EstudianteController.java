package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Estudiante;
import com.EduRefuerzo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var estudiantes = estudianteService.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "listadoEstudiantes";
    }

    @GetMapping("/nuevo")
    public String estudianteNuevo(Estudiante estudiante) {
        return "formularioEstudiante";
    }

    @PostMapping("/guardar")
    public String guardar(Estudiante estudiante) {
        estudianteService.save(estudiante);
        return "redirect:/estudiante/listado";
    }

    @GetMapping("/eliminar/{idEstudiante}")
    public String eliminar(Estudiante estudiante) {
        estudianteService.delete(estudiante);
        return "redirect:/estudiante/listado";
    }

    @GetMapping("/modificar/{idEstudiante}")
    public String modificar(Estudiante estudiante, Model model) {
        estudiante = estudianteService.getEstudiante(estudiante);
        model.addAttribute("estudiante", estudiante);
        return "formularioEstudiante";
    }

}