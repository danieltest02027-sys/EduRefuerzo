
package com.EduRefuerzo.domain;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_administrador")
    private Long idAdministrador;

    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
}