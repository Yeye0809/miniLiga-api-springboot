package com.yeferson.miniLiga.service;


import com.yeferson.miniLiga.dto.JugadorRequestDto;
import com.yeferson.miniLiga.dto.JugadorResponseDto;
import com.yeferson.miniLiga.entity.Jugador;

import java.util.List;

public interface JugadorService {

    JugadorResponseDto saveJugador(JugadorRequestDto dto);
    List<JugadorResponseDto> getJugadores();
}
