/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.asistencia.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.senati.asistencia.entity.Asistencia;
import pe.senati.asistencia.repository.AsistenciaRepository;
import pe.senati.asistencia.service.AsistenciaService;

/**
 *
 * @author Yamilly Prado
 */
@Service
public class AsistenciaServiceImpl implements AsistenciaService{
    
    @Autowired
    private AsistenciaRepository asistenciaRepository;
    
    @Override
    public List<Asistencia> findAll() {
        return (List<Asistencia>)asistenciaRepository.findAll();
    }
    
    @Override
    public Asistencia save(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }
    
}
