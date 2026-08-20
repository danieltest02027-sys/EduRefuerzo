package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Publicacion;
import com.EduRefuerzo.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publicacion")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var publicaciones = publicacionService.getPublicaciones();
        model.addAttribute("publicaciones", publicaciones);
        return "listadoPublicaciones";
    }

    @GetMapping("/nuevo")
    public String nuevo(Publicacion publicacion) {
        return "formularioPublicacion";
    }

    @PostMapping("/guardar")
    public String guardar(Publicacion publicacion) {
        publicacionService.save(publicacion);
        return "redirect:/publicacion/listado";
    }

    // 🔥 AQUÍ el cambio importante
    @GetMapping("/eliminar/{idPublicacion}")
    public String eliminar(@PathVariable Long idPublicacion) {
        Publicacion p = new Publicacion();
        p.setIdPublicacion(idPublicacion);
        publicacionService.delete(p);
        return "redirect:/publicacion/listado";
    }

    
    @GetMapping("/modificar/{idPublicacion}")
    public String modificar(@PathVariable Long idPublicacion, Model model) {
        Publicacion p = new Publicacion();
        p.setIdPublicacion(idPublicacion);
        p = publicacionService.getPublicacion(p);
        model.addAttribute("publicacion", p);
        return "formularioPublicacion";
    }
}