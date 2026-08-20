package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name="publicacion")
public class Publicacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublicacion;

    private String titulo;
    private String resumen;

    @Column(length = 2000)
    private String contenido;

    private String imagen;
    private LocalDate fechaPublicacion;
    private String estado;

    public Publicacion() {
        this.fechaPublicacion = LocalDate.now(); 
    }
}