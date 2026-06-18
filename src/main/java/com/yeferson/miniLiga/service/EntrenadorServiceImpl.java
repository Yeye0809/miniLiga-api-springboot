package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.EntrenadorRequestDto;
import com.yeferson.miniLiga.dto.EntrenadorResponseDto;
import com.yeferson.miniLiga.entity.Entrenador;
import com.yeferson.miniLiga.entity.Equipo;
import com.yeferson.miniLiga.mapper.EntrenadorMapper;
import com.yeferson.miniLiga.repository.EntrenadorRepository;
import com.yeferson.miniLiga.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService{

    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    EntrenadorRepository entrenadorRepository;

    @Override
    public EntrenadorResponseDto saveEntrenador(EntrenadorRequestDto dto) {
        Entrenador entrenador = new Entrenador();
        Equipo equipo = equipoRepository.findById(dto.getEquipoId()).orElseThrow(()-> new RuntimeException("El equipo no esta registrado"));

        entrenador.setNombre(dto.getNombre());
        entrenador.setEquipo(equipo);

        equipo.setEntrenador(entrenador);

        Entrenador entrenadorSave = entrenadorRepository.save(entrenador);

        return EntrenadorMapper.toDto(entrenadorSave);

    }

    @Override
    public List<EntrenadorResponseDto> getEntrenador(){
        return entrenadorRepository.findAll().stream().map(EntrenadorMapper::toDto).toList();
    }
}
