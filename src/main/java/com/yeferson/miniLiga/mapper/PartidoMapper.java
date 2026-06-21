package com.yeferson.miniLiga.mapper;

import com.yeferson.miniLiga.dto.PartidoResponseDto;
import com.yeferson.miniLiga.entity.Partido;

public class PartidoMapper {

    public static PartidoResponseDto toDto(Partido p){
        PartidoResponseDto dto = new PartidoResponseDto();
        dto.setId(p.getId());
        dto.setFecha(p.getFecha());
        dto.setEquipoLocal(p.getEquipoLocal().getNombre());
        dto.setEquipoVisitante(p.getEquipoVisitante().getNombre());

        if( p.getGolesEquipoLocal() != null ){
            dto.setGolesEquipoLocal(p.getGolesEquipoLocal());
        }

        if( p.getGolesEquipoVisitante() != null ){
            dto.setGolesEquipoVisitante(p.getGolesEquipoVisitante());
        }

        dto.setFinalizado(p.getFinalizado());

        return dto;

    }
}
