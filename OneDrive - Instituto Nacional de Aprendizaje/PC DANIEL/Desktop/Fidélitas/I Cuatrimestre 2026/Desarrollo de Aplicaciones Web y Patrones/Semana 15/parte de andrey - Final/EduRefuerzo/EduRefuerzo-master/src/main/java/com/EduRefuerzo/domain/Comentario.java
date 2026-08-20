package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long idComentario;

    private String contenido;
    private LocalDate fecha;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_recurso")
    private Recurso recurso;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    public Comentario() {
        this.fecha = LocalDate.now();
        this.estado = "Activo";
    }
}