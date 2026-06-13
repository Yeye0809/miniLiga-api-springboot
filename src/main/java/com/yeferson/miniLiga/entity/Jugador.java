package com.yeferson.miniLiga.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private  Long numeroCamisa;
    private String posición;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    @JsonBackReference
    private Equipo equipo;

}
