package com.yeferson.miniLiga.mapper;

import com.yeferson.miniLiga.dto.JugadorResponseDto;
import com.yeferson.miniLiga.entity.Jugador;

public class JugadorMapper {
    public static JugadorResponseDto toDto(Jugador j){
        JugadorResponseDto dto = new JugadorResponseDto();
        dto.setId(j.getId());
        dto.setPosicion(j.getPosicion());
        dto.setNumeroCamisa(j.getNumeroCamisa());

        if( j.getEquipo() != null ){
            dto.setEquipo(j.getEquipo());
        }
        dto.setNombre(j.getNombre());

        return dto;
    }
}
