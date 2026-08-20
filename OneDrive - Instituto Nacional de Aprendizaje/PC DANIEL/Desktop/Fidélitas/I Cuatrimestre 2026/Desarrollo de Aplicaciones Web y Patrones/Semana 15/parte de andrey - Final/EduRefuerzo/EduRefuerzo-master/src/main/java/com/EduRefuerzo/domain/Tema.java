package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="tema")
public class Tema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tema")
    private Long idTema;
    private String nombre;
    private String descripcion;
    private String estado;
    private Long idMateria; // Para la relación con Materia
}