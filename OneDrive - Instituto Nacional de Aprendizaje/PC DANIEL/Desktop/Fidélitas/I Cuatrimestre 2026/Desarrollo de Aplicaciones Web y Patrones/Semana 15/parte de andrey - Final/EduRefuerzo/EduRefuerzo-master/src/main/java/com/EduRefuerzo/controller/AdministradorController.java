package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Administrador;
import com.EduRefuerzo.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var administradores = administradorService.getAdministradores();
        model.addAttribute("administradores", administradores);
        return "listado";
    }

    @GetMapping("/nuevo")
    public String administradorNuevo(Administrador administrador) {
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Administrador administrador) {
        administradorService.save(administrador);
        return "redirect:/administrador/listado";
    }

    @GetMapping("/eliminar/{idAdministrador}")
    public String eliminar(Administrador administrador) {
        administradorService.delete(administrador);
        return "redirect:/administrador/listado";
    }

    @GetMapping("/modificar/{idAdministrador}")
    public String modificar(Administrador administrador, Model model) {
        administrador = administradorService.getAdministrador(administrador);
        model.addAttribute("administrador", administrador);
        return "formulario";
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }
}
