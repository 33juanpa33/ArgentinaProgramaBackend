package com.portfolio.Alfonso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEdu;
    
    private String tituloEdu;
    private String fechaInicioEdu;
    private String fechaFinEdu;
    @Column (length = 500)
    private String descripcionEdu;

    public Educacion() {
    }

    public Educacion(Long idEdu, String tituloEdu, String fechaInicioEdu, String fechaFinEdu, String descripcionEdu) {
        this.idEdu = idEdu;
        this.tituloEdu = tituloEdu;
        this.fechaInicioEdu = fechaInicioEdu;
        this.fechaFinEdu = fechaFinEdu;
        this.descripcionEdu = descripcionEdu;
    }
    
}
