package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.MateriaFavorita;
import com.EduRefuerzo.service.EstudianteService;
import com.EduRefuerzo.service.MateriaFavoritaService;
import com.EduRefuerzo.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/materiaFavorita")
public class MateriaFavoritaController {

    @Autowired
    private MateriaFavoritaService materiaFavoritaService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private MateriaService materiaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var materiasFavoritas = materiaFavoritaService.getMateriasFavoritas();
        model.addAttribute("materiasFavoritas", materiasFavoritas);
        return "listadoMateriaFavorita";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        MateriaFavorita materiaFavorita = new MateriaFavorita();
        model.addAttribute("materiaFavorita", materiaFavorita);
        model.addAttribute("estudiantes", estudianteService.getEstudiantes());
        model.addAttribute("materias", materiaService.getMaterias());
        return "formularioMateriaFavorita";
    }

    @PostMapping("/guardar")
    public String guardar(MateriaFavorita materiaFavorita, Model model) {

        if (materiaFavorita.getEstudiante() != null
                && materiaFavorita.getMateria() != null
                && materiaFavorita.getEstudiante().getIdEstudiante() != null
                && materiaFavorita.getMateria().getIdMateria() != null) {

            boolean mismoRegistro = materiaFavorita.getIdFavorita() != null;

            boolean yaExiste = materiaFavoritaService.existsByEstudianteAndMateria(
                    materiaFavorita.getEstudiante().getIdEstudiante(),
                    materiaFavorita.getMateria().getIdMateria()
            );

            if (yaExiste && !mismoRegistro) {
                model.addAttribute("error", "La materia ya se encuentra en favoritos");
                model.addAttribute("materiaFavorita", materiaFavorita);
                model.addAttribute("estudiantes", estudianteService.getEstudiantes());
                model.addAttribute("materias", materiaService.getMaterias());
                return "formularioMateriaFavorita";
            }
        }

        if (materiaFavorita.getEstado() == null || materiaFavorita.getEstado().isBlank()) {
            materiaFavorita.setEstado("Activo");
        }

        materiaFavoritaService.save(materiaFavorita);
        return "redirect:/materiaFavorita/listado";
    }

    @GetMapping("/modificar/{idFavorita}")
    public String modificar(MateriaFavorita materiaFavorita, Model model) {
        materiaFavorita = materiaFavoritaService.getMateriaFavorita(materiaFavorita).orElse(null);

        if (materiaFavorita == null) {
            return "redirect:/materiaFavorita/listado";
        }

        model.addAttribute("materiaFavorita", materiaFavorita);
        model.addAttribute("estudiantes", estudianteService.getEstudiantes());
        model.addAttribute("materias", materiaService.getMaterias());

        return "formularioMateriaFavorita";
    }

    @GetMapping("/eliminar/{idFavorita}")
    public String eliminar(MateriaFavorita materiaFavorita) {
        materiaFavoritaService.delete(materiaFavorita);
        return "redirect:/materiaFavorita/listado";
    }
}