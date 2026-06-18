package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.EquipoRequestDto;
import com.yeferson.miniLiga.dto.EquipoResponseDto;

import java.util.List;

public interface EquipoService {

    EquipoResponseDto saveEquipo(EquipoRequestDto dto);
    List<EquipoResponseDto> getEquipos();

}
