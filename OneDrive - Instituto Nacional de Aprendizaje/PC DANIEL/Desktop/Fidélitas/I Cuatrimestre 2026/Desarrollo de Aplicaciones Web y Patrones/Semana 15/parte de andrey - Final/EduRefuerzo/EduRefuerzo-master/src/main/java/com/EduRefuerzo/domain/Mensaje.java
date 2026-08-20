package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "mensaje")
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private Long idMensaje;

    @ManyToOne
    @JoinColumn(name = "id_chat")
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    private String contenido;
    private LocalDate fecha;
    private String estado;

    public Mensaje() {
        this.fecha = LocalDate.now();
        this.estado = "Activo";
    }
}