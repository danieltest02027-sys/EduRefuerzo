package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "nota_academica")
public class NotaAcademica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idNota;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;

    private String titulo;
    private String contenido;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    private String estado;
}