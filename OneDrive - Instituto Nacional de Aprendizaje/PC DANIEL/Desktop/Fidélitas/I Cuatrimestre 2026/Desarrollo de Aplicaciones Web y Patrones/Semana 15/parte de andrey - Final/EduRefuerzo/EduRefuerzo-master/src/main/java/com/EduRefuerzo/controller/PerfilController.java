package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Perfil;
import com.EduRefuerzo.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var perfiles = perfilService.getPerfiles();
        model.addAttribute("perfiles", perfiles);
        return "listadoPerfiles";
    }

    @GetMapping("/nuevo")
    public String perfilNuevo(Perfil perfil) {
        return "formularioPerfil";
    }

    @PostMapping("/guardar")
    public String guardar(Perfil perfil) {
        perfilService.save(perfil);
        return "redirect:/perfil/listado";
    }

    @GetMapping("/eliminar/{idPerfil}")
    public String eliminar(Perfil perfil) {
        perfilService.delete(perfil);
        return "redirect:/perfil/listado";
    }

    @GetMapping("/modificar/{idPerfil}")
    public String modificar(Perfil perfil, Model model) {
        perfil = perfilService.getPerfil(perfil);
        model.addAttribute("perfil", perfil);
        return "formularioPerfil";
    }

}