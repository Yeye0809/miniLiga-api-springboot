package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.TorneoRequestDto;
import com.yeferson.miniLiga.dto.TorneoResponseDto;

public interface TorneoService {

    TorneoResponseDto saveTorneo(TorneoRequestDto dto);
}
