package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "chat")
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chat")
    private Long idChat;

    @ManyToOne
    @JoinColumn(name = "id_usuario_origen")
    private Estudiante usuarioOrigen;

    @ManyToOne
    @JoinColumn(name = "id_usuario_destino")
    private Estudiante usuarioDestino;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    private String estado;

    public Chat() {
        this.fechaCreacion = LocalDate.now();
        this.estado = "Activo";
    }
}