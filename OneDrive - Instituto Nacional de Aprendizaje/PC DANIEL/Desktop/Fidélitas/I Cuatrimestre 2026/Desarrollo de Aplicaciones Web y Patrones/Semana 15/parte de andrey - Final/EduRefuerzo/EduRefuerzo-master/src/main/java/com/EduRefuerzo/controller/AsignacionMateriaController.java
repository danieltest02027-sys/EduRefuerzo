package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.AsignacionMateria;
import com.EduRefuerzo.service.AsignacionMateriaService;
import com.EduRefuerzo.service.EstudianteService;
import com.EduRefuerzo.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/asignacion")
public class AsignacionMateriaController {

    @Autowired
    private AsignacionMateriaService asignacionMateriaService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var asignaciones = asignacionMateriaService.getAsignaciones();
        model.addAttribute("asignaciones", asignaciones);
        return "listadoAsignaciones";
    }

    @GetMapping("/nuevo")
    public String asignacionNueva(AsignacionMateria asignacion, Model model) {
        var estudiantes = estudianteService.getEstudiantes();
        var materias = materiaService.getMaterias();

        model.addAttribute("asignacion", asignacion);
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("materias", materias);

        return "formularioAsignacion";
    }

    @PostMapping("/guardar")
    public String asignacionGuardar(AsignacionMateria asignacion, Model model, RedirectAttributes redirectAttributes) {
        Long idEstudiante = asignacion.getEstudiante().getIdEstudiante();
        Long idMateria = Long.valueOf(asignacion.getMateria().getIdMateria());

        var asignaciones = asignacionMateriaService.getAsignaciones();

        for (var existente : asignaciones) {
            boolean mismoEstudiante = existente.getEstudiante().getIdEstudiante().equals(idEstudiante);
            boolean mismaMateria = existente.getMateria().getIdMateria().equals(asignacion.getMateria().getIdMateria());
            boolean distintoRegistro = asignacion.getIdAsignacion() == null
                    || !existente.getIdAsignacion().equals(asignacion.getIdAsignacion());

            if (mismoEstudiante && mismaMateria && distintoRegistro) {
                var estudiantes = estudianteService.getEstudiantes();
                var materias = materiaService.getMaterias();

                model.addAttribute("asignacion", asignacion);
                model.addAttribute("estudiantes", estudiantes);
                model.addAttribute("materias", materias);
                model.addAttribute("mensajeError", "Este estudiante ya tiene asignada esa materia.");

                return "formularioAsignacion";
            }
        }

        boolean esNueva = (asignacion.getIdAsignacion() == null);
        asignacionMateriaService.save(asignacion);

        if (esNueva) {
            redirectAttributes.addFlashAttribute("mensajeExito", "Asignación creada correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("mensajeExito", "Asignación actualizada correctamente.");
        }

        return "redirect:/asignacion/listado";
    }

    @GetMapping("/eliminar/{idAsignacion}")
    public String asignacionEliminar(AsignacionMateria asignacion, RedirectAttributes redirectAttributes) {
        asignacionMateriaService.delete(asignacion);
        redirectAttributes.addFlashAttribute("mensajeExito", "Asignación eliminada correctamente.");
        return "redirect:/asignacion/listado";
    }

    @GetMapping("/modificar/{idAsignacion}")
    public String asignacionModificar(AsignacionMateria asignacion, Model model) {
        asignacion = asignacionMateriaService.getAsignacion(asignacion);
        var estudiantes = estudianteService.getEstudiantes();
        var materias = materiaService.getMaterias();

        model.addAttribute("asignacion", asignacion);
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("materias", materias);

        return "formularioAsignacion";
    }
}
