package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_perfil")
    private Long idPerfil;

    private String nombreCompleto;
    private String correo;
    private String carrera;
    private String descripcion;

}