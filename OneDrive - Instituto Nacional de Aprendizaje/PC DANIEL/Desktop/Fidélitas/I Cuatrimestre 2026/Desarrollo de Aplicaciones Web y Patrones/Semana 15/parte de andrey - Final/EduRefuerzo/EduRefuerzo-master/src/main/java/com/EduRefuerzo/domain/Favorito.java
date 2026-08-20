package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "favorito")
public class Favorito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFavorito;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_recurso")
    private Recurso recurso;

    private LocalDate fecha;
    private String estado;

    public Favorito() {
        this.fecha = LocalDate.now();
        this.estado = "Activo";
    }
}