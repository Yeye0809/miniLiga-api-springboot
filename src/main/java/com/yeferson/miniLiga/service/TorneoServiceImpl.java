package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.TorneoRequestDto;
import com.yeferson.miniLiga.dto.TorneoResponseDto;
import com.yeferson.miniLiga.entity.Torneo;
import com.yeferson.miniLiga.mapper.TorneoMapper;
import com.yeferson.miniLiga.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoServiceImpl implements TorneoService{

    @Autowired
    TorneoRepository torneoRepository;

    @Override
    public TorneoResponseDto saveTorneo(TorneoRequestDto dto) {
        Torneo torneo = new Torneo();
        torneo.setNombre(dto.getNombre());
        torneo.setDescripcion(dto.getDescripcion());
        torneo.setFechaInicio(dto.getFechaInicio());
        torneo.setFechaFin(dto.getFechaFin());
        torneo.setActivo(true);

        Torneo torneoSave = torneoRepository.save(torneo);

        return TorneoMapper.toDto(torneoSave);
    }

    @Override
    public List<TorneoResponseDto> getTorneos(){
        return torneoRepository.findAll().stream().map(TorneoMapper::toDto).toList();
    }
}
