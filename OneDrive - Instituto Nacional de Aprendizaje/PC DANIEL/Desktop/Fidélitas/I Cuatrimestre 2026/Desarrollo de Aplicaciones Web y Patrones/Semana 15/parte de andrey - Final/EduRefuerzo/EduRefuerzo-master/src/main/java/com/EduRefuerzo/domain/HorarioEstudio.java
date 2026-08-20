package com.EduRefuerzo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "horario_estudio")
public class HorarioEstudio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long idHorario;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;

    private Date fecha;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "hora_fin")
    private LocalTime horaFin;

    private String descripcion;
    private String estado;
}