package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.EntrenadorRequestDto;
import com.yeferson.miniLiga.dto.EntrenadorResponseDto;

import java.util.List;

public interface EntrenadorService {
    EntrenadorResponseDto saveEntrenador(EntrenadorRequestDto dto);
    List<EntrenadorResponseDto> getEntrenador();
}
