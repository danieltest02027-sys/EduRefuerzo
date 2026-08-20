package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_estudiante")
    private Long idEstudiante;

    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
    private String carrera;

}