/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.asistencia.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.senati.asistencia.entity.Asistencia;
import pe.senati.asistencia.service.AsistenciaService;

/**
 *
 * @author Yamilly Prado
 */
@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {
    
    @Autowired
    private AsistenciaService asistenciaService;
    
    @GetMapping("/listar")
    public List<Asistencia> findAll() {
        return asistenciaService.findAll();
    }
    
    @PostMapping("/guardar")
    public Asistencia save(@RequestBody Asistencia asistencia){
        return asistenciaService.save(asistencia);
    }
    
}
