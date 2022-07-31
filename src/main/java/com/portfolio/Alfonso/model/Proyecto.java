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
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProy;
    
    private String tituloProy;
    @Column (length = 500)
    private String descripcionProy;
    private String fotoProy;

    public Proyecto() {
    }

    public Proyecto(Long idProy, String tituloProy, String descripcionProy, String fotoProy) {
        this.idProy = idProy;
        this.tituloProy = tituloProy;
        this.descripcionProy = descripcionProy;
        this.fotoProy = fotoProy;
    }
    
}
