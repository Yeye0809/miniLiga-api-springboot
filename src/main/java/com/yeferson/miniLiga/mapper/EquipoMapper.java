package com.yeferson.miniLiga.mapper;

import com.yeferson.miniLiga.dto.EquipoResponseDto;
import com.yeferson.miniLiga.entity.Equipo;
import com.yeferson.miniLiga.entity.Jugador;

public class EquipoMapper {

    public static EquipoResponseDto toDto(Equipo equipo){
        EquipoResponseDto dto = new EquipoResponseDto();

        dto.setId(equipo.getId());
        dto.setNombre(equipo.getNombre());
        dto.setJugadores(equipo.getJugadores());
        dto.setNombreTorneo(equipo.getTorneo().getNombre());
        dto.setEntrenador(equipo.getEntrenador());

        return dto;
    }

}
