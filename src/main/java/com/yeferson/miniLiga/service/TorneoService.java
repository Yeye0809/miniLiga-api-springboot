package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.TorneoRequestDto;
import com.yeferson.miniLiga.dto.TorneoResponseDto;

import java.util.List;

public interface TorneoService {

    TorneoResponseDto saveTorneo(TorneoRequestDto dto);
    List<TorneoResponseDto> getTorneos();
}
