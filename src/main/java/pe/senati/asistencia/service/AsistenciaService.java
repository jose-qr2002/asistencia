/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.asistencia.service;

import java.util.List;
import pe.senati.asistencia.entity.Asistencia;

/**
 *
 * @author Yamilly Prado
 */
public interface AsistenciaService {
    public List<Asistencia> findAll();
    
    public Asistencia save(Asistencia asistencia);
}
