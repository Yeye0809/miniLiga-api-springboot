package com.yeferson.miniLiga.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Partido {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipo_local")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante")
    private Equipo equipoVisitante;

    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    private LocalDate fecha;
    private boolean finalizado;

}
