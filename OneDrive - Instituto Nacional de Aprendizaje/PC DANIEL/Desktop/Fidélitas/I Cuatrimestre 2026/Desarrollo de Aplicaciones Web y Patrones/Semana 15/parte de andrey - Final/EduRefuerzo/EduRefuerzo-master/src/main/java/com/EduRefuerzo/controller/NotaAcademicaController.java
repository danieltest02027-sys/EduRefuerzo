package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.NotaAcademica;
import com.EduRefuerzo.service.EstudianteService;
import com.EduRefuerzo.service.MateriaService;
import com.EduRefuerzo.service.NotaAcademicaService;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notaAcademica")
public class NotaAcademicaController {

    @Autowired
    private NotaAcademicaService notaAcademicaService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var notas = notaAcademicaService.getNotas();
        model.addAttribute("notas", notas);
        return "listadoNotaAcademica";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        NotaAcademica notaAcademica = new NotaAcademica();
        model.addAttribute("notaAcademica", notaAcademica);
        model.addAttribute("estudiantes", estudianteService.getEstudiantes());
        model.addAttribute("materias", materiaService.getMaterias());
        return "formularioNotaAcademica";
    }

    @PostMapping("/guardar")
    public String guardar(NotaAcademica notaAcademica, Model model) {

        if (notaAcademica.getMateria() == null || notaAcademica.getMateria().getIdMateria() == null) {
            model.addAttribute("error", "Debe seleccionar una materia");
            model.addAttribute("notaAcademica", notaAcademica);
            model.addAttribute("estudiantes", estudianteService.getEstudiantes());
            model.addAttribute("materias", materiaService.getMaterias());
            return "formularioNotaAcademica";
        }

        if (notaAcademica.getTitulo() == null || notaAcademica.getTitulo().isBlank()) {
            model.addAttribute("error", "Debe ingresar un título");
            model.addAttribute("notaAcademica", notaAcademica);
            model.addAttribute("estudiantes", estudianteService.getEstudiantes());
            model.addAttribute("materias", materiaService.getMaterias());
            return "formularioNotaAcademica";
        }

        if (notaAcademica.getContenido() == null || notaAcademica.getContenido().isBlank()) {
            model.addAttribute("error", "Debe ingresar el contenido de la nota");
            model.addAttribute("notaAcademica", notaAcademica);
            model.addAttribute("estudiantes", estudianteService.getEstudiantes());
            model.addAttribute("materias", materiaService.getMaterias());
            return "formularioNotaAcademica";
        }

        if (notaAcademica.getFechaCreacion() == null) {
            notaAcademica.setFechaCreacion(new Date(System.currentTimeMillis()));
        }

        if (notaAcademica.getEstado() == null || notaAcademica.getEstado().isBlank()) {
            notaAcademica.setEstado("Activo");
        }

        notaAcademicaService.save(notaAcademica);
        return "redirect:/notaAcademica/listado";
    }

    @GetMapping("/modificar/{idNota}")
    public String modificar(NotaAcademica notaAcademica, Model model) {
        notaAcademica = notaAcademicaService.getNota(notaAcademica).orElse(null);

        if (notaAcademica == null) {
            return "redirect:/notaAcademica/listado";
        }

        model.addAttribute("notaAcademica", notaAcademica);
        model.addAttribute("estudiantes", estudianteService.getEstudiantes());
        model.addAttribute("materias", materiaService.getMaterias());

        return "formularioNotaAcademica";
    }

    @GetMapping("/eliminar/{idNota}")
    public String eliminar(NotaAcademica notaAcademica) {
        notaAcademicaService.delete(notaAcademica);
        return "redirect:/notaAcademica/listado";
    }
}
