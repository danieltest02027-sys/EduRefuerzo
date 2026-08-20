package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "recurso")
public class Recurso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recurso")
    private Long idRecurso;

    private String titulo;
    private String descripcion;
    private String tipo;
    private String archivo;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_tema")
    private Tema tema;
}
