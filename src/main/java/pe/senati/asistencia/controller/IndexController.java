/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.asistencia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.senati.asistencia.service.PersonaService;

/**
 *
 * @author Yamilly Prado
 */
@Controller
public class IndexController {
    
    //private PersonaService personaService;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("TITULO", "Bienvenido a Spring Boot");
        return "index";
    }
    
    @GetMapping("/menu/persona")
    public String indexPersona(Model model) {
        model.addAttribute("mensaje", "Personas");
        return "personas/persona";
    }
    
    @GetMapping("/menu/asistencia")
    public String indexAsistencia(Model model) {
        model.addAttribute("mensaje2", "Asistencias");
        return "asistencias/asistencia";
    }
}
