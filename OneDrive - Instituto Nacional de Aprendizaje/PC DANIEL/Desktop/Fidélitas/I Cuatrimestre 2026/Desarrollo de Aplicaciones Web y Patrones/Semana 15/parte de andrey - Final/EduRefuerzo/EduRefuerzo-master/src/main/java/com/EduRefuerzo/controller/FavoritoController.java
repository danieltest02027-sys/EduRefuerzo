package com.EduRefuerzo.controller;

import com.EduRefuerzo.domain.Favorito;
import com.EduRefuerzo.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/favorito")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    
    private Long idEstudiante = 1L;

    @GetMapping("/listado")
    public String listado(Model model) {
        var favoritos = favoritoService.getFavoritos(idEstudiante);
        model.addAttribute("favoritos", favoritos);
        return "listadoFavoritos";
    }

    @GetMapping("/toggle/{idRecurso}")
    public String toggle(@PathVariable Long idRecurso) {
        favoritoService.toggleFavorito(idEstudiante, idRecurso);
        return "redirect:/recurso/listado";
    }

    @GetMapping("/eliminar/{idFavorito}")
    public String eliminar(Favorito favorito) {
        favoritoService.delete(favorito);
        return "redirect:/favorito/listado";
    }
}