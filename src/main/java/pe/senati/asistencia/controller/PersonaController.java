/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.asistencia.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.senati.asistencia.entity.Persona;
import pe.senati.asistencia.service.PersonaService;

/**
 *
 * @author Yamilly Prado
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/listar")
    public List<Persona> findAll() {
        return personaService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Integer id){
        Persona persona = personaService.findById(id);
        return ResponseEntity.ok(persona);
    }
    
    @GetMapping("/dni/{dni}")
    public ResponseEntity<Persona> findByPersDni(@PathVariable String dni){
        Persona persona = personaService.findByPersDni(dni);
        return ResponseEntity.ok(persona);
    }
    
    @PostMapping("/guardar")
    public Persona save(@RequestBody Persona persona){
        return personaService.save(persona);
    }
    
    @PutMapping("/modificar")
    public Persona update(@RequestBody Persona persona) {
        return personaService.save(persona);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        personaService.deleteById(id);
    }
    
    
}
