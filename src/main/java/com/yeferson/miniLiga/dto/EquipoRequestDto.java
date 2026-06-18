package com.yeferson.miniLiga.dto;

import com.yeferson.miniLiga.entity.Entrenador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipoRequestDto {

    private String nombre;
    private Long torneo;
    private List<Long> idJugadores;
    private Entrenador entrenador;

}
