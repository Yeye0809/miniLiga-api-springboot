package com.yeferson.miniLiga.mapper;

import com.yeferson.miniLiga.dto.EntrenadorResponseDto;
import com.yeferson.miniLiga.entity.Entrenador;

public class EntrenadorMapper {

    public static EntrenadorResponseDto toDto(Entrenador e){
        EntrenadorResponseDto dto = new EntrenadorResponseDto();

        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        if(e.getEquipo() != null ){
            dto.setEquipo(e.getEquipo().getNombre());
        }


        return dto;
    }

}
