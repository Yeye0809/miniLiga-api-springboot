package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.PartidoRequestDto;
import com.yeferson.miniLiga.dto.PartidoResponseDto;

import java.util.List;

public interface PartidoService {

    PartidoResponseDto savePartido(PartidoRequestDto dto);
    List<PartidoResponseDto> getPartidos();
    PartidoResponseDto getPartidoById(Long id);
    PartidoResponseDto updateFinalPartido(Long id, PartidoRequestDto dto );
    PartidoResponseDto updatePartido(Long id, PartidoRequestDto dto );

}
