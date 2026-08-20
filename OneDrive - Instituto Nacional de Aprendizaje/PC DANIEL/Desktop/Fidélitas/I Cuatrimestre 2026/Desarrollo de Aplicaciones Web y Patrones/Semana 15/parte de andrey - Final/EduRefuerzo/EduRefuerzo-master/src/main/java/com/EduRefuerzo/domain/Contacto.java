package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="contacto")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContacto;

    private String nombre;
    private String correo;
    private String tipo;   
    private String estado; 
}