package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.EstadisticasDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EstatdisticasService {

    List<EstadisticasDto> mostrarEstadisticas(Long torneoId);
}
