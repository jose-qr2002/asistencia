/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.asistencia.service;

import java.util.List;
import pe.senati.asistencia.entity.Persona;

/**
 *
 * @author Yamilly Prado
 */
public interface PersonaService {
    public List<Persona> findAll();
    
    public Persona findById(Integer id);
    
    public Persona findByPersDni(String dni);
    
    public Persona save(Persona persona);
    
    public void deleteById(Integer id);
    
    
    
}
