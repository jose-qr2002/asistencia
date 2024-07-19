/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.asistencia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Yamilly Prado
 */
@Data
@Entity
@Table(name = "persona")

public class Persona {
    
    @Id
    @Column(name = "pers_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer persId;
    
    @Column(name = "pers_nombre")
    private String persNombre;
    
    @Column(name = "pers_apellido")
    private String persApellido;
    
    @Column(name = "pers_dni")
    private String persDni;
    
    @Column(name = "pers_sexo")
    private String persSexo;
    
    @Column(name = "pers_direccion")
    private String persDireccion;

}
