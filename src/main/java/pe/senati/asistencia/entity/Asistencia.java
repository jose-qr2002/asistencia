/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.asistencia.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author Yamilly Prado
 */
@Data
@Entity
@Table(name = "asistencia")
public class Asistencia {
    
    @Id
    @Column(name = "asis_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer asisId;
    
    @ManyToOne
    @JoinColumn(name = "pers_id")
    private Persona persona;
    
    @Column(name = "asis_fecha")
    @Temporal(TemporalType.DATE)
    private Date asisFecha;
    
    @Column (name = "asis_hora")
    private String asisHora;
    
    @Column (name = "asis_tipoControl")
    private String asisTipoControl; 
    
    @PrePersist
    protected void onCreate() {
        asisFecha = new Date();
    }
    
    
    
    

}
