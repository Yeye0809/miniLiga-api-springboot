package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.EquipoRequestDto;
import com.yeferson.miniLiga.dto.EquipoResponseDto;
import com.yeferson.miniLiga.entity.Equipo;
import com.yeferson.miniLiga.entity.Jugador;
import com.yeferson.miniLiga.entity.Torneo;
import com.yeferson.miniLiga.mapper.EquipoMapper;
import com.yeferson.miniLiga.repository.EquipoRepository;
import com.yeferson.miniLiga.repository.JugadorRepository;
import com.yeferson.miniLiga.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class EquipoServiceImpl implements EquipoService{

    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    TorneoRepository torneoRepository;

    @Autowired
    JugadorRepository jugadorRepository;

    @Override
    public EquipoResponseDto saveEquipo(EquipoRequestDto dto){
        Torneo torneo = torneoRepository.findById(dto.getTorneo()).orElseThrow(()-> new RuntimeException("torneo no existe"));
        List<Jugador> jugadores = new ArrayList<>();

        for( Long id : dto.getIdJugadores()){
            jugadores.add(jugadorRepository.findById(id).orElseThrow(()-> new RuntimeException("el jugador no existe")));
        }

        Equipo equipo = new Equipo();
        equipo.setNombre(dto.getNombre());
        equipo.setJugadores(jugadores);
        equipo.setTorneo(torneo);

        for( Jugador  j : jugadores ){
            j.setEquipo(equipo);
        }

        Equipo equipoSave = equipoRepository.save(equipo);

        return EquipoMapper.toDto(equipoSave);
    }

    @Override
    public List<EquipoResponseDto> getEquipos(){
        return equipoRepository.findAll().stream().map(EquipoMapper::toDto).toList();
    }

}
