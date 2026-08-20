package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Contacto;
import com.EduRefuerzo.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var contactos = contactoService.getContactos();
        model.addAttribute("contactos", contactos);
        return "listadoContactos";
    }

    @GetMapping("/nuevo")
    public String nuevo(Contacto contacto) {
        return "formularioContacto"; 
    }

    @PostMapping("/guardar")
    public String guardar(Contacto contacto) {
        contactoService.save(contacto);
        return "redirect:/contacto/listado";
    }

    @GetMapping("/eliminar/{idContacto}")
    public String eliminar(Contacto contacto) {
        contactoService.delete(contacto);
        return "redirect:/contacto/listado";
    }

    @GetMapping("/modificar/{idContacto}")
    public String modificar(Contacto contacto, Model model) {
        contacto = contactoService.getContacto(contacto);
        model.addAttribute("contacto", contacto);
        return "formularioContacto"; 
    }
}