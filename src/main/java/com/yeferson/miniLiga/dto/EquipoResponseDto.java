package com.yeferson.miniLiga.dto;

import com.yeferson.miniLiga.entity.Entrenador;
import com.yeferson.miniLiga.entity.Jugador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipoResponseDto {

    private Long id;
    private String nombre;
    private String nombreTorneo;
    private List<Jugador> jugadores;
    private Entrenador entrenador;

}
