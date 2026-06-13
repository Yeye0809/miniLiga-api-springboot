package com.yeferson.miniLiga.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    @JsonBackReference
    private Torneo torneo;

    @OneToMany(mappedBy = "equipo" )
    @JsonManagedReference
    private List<Jugador> jugadores;

    @OneToOne
    @JoinColumn(name = "entrenador_id")
    @JsonManagedReference
    private Entrenador entrenador;
}
