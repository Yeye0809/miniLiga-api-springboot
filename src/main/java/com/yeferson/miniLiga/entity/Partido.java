package com.yeferson.miniLiga.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    @JsonBackReference
    private Torneo torneo;

    private Integer golesEquipoLocal;
    private Integer golesEquipoVisitante;
    private LocalDate fecha;
    private Boolean finalizado;

}
