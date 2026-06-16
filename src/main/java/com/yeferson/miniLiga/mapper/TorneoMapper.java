package com.yeferson.miniLiga.mapper;

import com.yeferson.miniLiga.dto.TorneoResponseDto;
import com.yeferson.miniLiga.entity.Torneo;

public class TorneoMapper {

    public static TorneoResponseDto toDto(Torneo torneo){
        TorneoResponseDto dto = new TorneoResponseDto();
        dto.setId(torneo.getId());
        dto.setNombre(torneo.getNombre());
        dto.setDescripcion(torneo.getDescripcion());
        dto.setActivo(torneo.getActivo());
        dto.setFechaInicio(torneo.getFechaInicio());
        dto.setFechaFin(torneo.getFechaFin());

        if( torneo.getEquipos() != null){
            dto.setEquipos(torneo.getEquipos());
        }

        return dto;
    }
}

