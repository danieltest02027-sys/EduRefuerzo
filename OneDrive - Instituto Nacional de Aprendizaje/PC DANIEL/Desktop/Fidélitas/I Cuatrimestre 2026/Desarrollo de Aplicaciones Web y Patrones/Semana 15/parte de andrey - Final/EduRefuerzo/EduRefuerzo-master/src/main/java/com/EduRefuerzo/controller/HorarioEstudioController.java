package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.HorarioEstudio;
import com.EduRefuerzo.service.EstudianteService;
import com.EduRefuerzo.service.HorarioEstudioService;
import com.EduRefuerzo.service.MateriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/horario")
public class HorarioEstudioController {

    @Autowired
    private HorarioEstudioService horarioEstudioService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var horarios = horarioEstudioService.getHorarios();
        model.addAttribute("horarios", horarios);
        return "listadoHorarios";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        HorarioEstudio horario = new HorarioEstudio();
        model.addAttribute("horario", horario);
        model.addAttribute("estudiantes", estudianteService.getEstudiantes());
        model.addAttribute("materias", materiaService.getMaterias());
        return "formularioHorario";
    }

    @PostMapping("/guardar")
    public String guardar(HorarioEstudio horario, Model model) {

        if (horario.getHoraInicio() != null && horario.getHoraFin() != null) {
            if (!horario.getHoraFin().isAfter(horario.getHoraInicio())) {
                model.addAttribute("error", "La hora de finalización debe ser mayor que la hora de inicio");
                model.addAttribute("estudiantes", estudianteService.getEstudiantes());
                model.addAttribute("materias", materiaService.getMaterias());
                model.addAttribute("horario", horario);
                return "formularioHorario";
            }
        }

        List<HorarioEstudio> horariosExistentes = horarioEstudioService.getHorariosPorEstudiante(
                horario.getEstudiante().getIdEstudiante()
        );

        boolean conflicto = false;

        for (HorarioEstudio h : horariosExistentes) {
            boolean mismaFecha = h.getFecha() != null && horario.getFecha() != null
                    && h.getFecha().equals(horario.getFecha());

            boolean mismoRegistro = horario.getIdHorario() != null
                    && h.getIdHorario().equals(horario.getIdHorario());

            if (mismaFecha && !mismoRegistro) {
                boolean seTraslapan = horario.getHoraInicio().isBefore(h.getHoraFin())
                        && horario.getHoraFin().isAfter(h.getHoraInicio());

                if (seTraslapan) {
                    conflicto = true;
                    break;
                }
            }
        }

        if (conflicto) {
            model.addAttribute("error", "Horario duplicado o en conflicto");
            model.addAttribute("estudiantes", estudianteService.getEstudiantes());
            model.addAttribute("materias", materiaService.getMaterias());
            model.addAttribute("horario", horario);
            return "formularioHorario";
        }

        if (horario.getEstado() == null || horario.getEstado().isBlank()) {
            horario.setEstado("Activo");
        }

        horarioEstudioService.save(horario);
        return "redirect:/horario/listado";
    }

    @GetMapping("/modificar/{idHorario}")
    public String modificar(HorarioEstudio horario, Model model) {
        horario = horarioEstudioService.getHorario(horario).orElse(null);

        if (horario == null) {
            return "redirect:/horario/listado";
        }

        model.addAttribute("horario", horario);
        model.addAttribute("estudiantes", estudianteService.getEstudiantes());
        model.addAttribute("materias", materiaService.getMaterias());

        return "formularioHorario";
    }

    @GetMapping("/eliminar/{idHorario}")
    public String eliminar(HorarioEstudio horario) {
        horarioEstudioService.delete(horario);
        return "redirect:/horario/listado";
    }
}
