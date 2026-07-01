package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.EquipoRequestDto;
import com.yeferson.miniLiga.dto.EquipoResponseDto;
import com.yeferson.miniLiga.entity.Entrenador;
import com.yeferson.miniLiga.entity.Equipo;
import com.yeferson.miniLiga.entity.Jugador;
import com.yeferson.miniLiga.entity.Torneo;
import com.yeferson.miniLiga.exeption.usuarioNoEncontradoException;
import com.yeferson.miniLiga.mapper.EquipoMapper;
import com.yeferson.miniLiga.repository.EntrenadorRepository;
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

    @Autowired
    EntrenadorRepository entrenadorRepository;

    @Override
    public EquipoResponseDto saveEquipo(EquipoRequestDto dto){
        Torneo torneo = torneoRepository.findById(dto.getTorneo()).orElseThrow(()-> new RuntimeException("torneo no existe"));
        List<Jugador> jugadores = new ArrayList<>();

        Entrenador entrenador = null;

        if( dto.getEntrenador() != null ){
            entrenador = entrenadorRepository.findById(dto.getEntrenador()).orElseThrow(()-> new RuntimeException("Entrenador no existe"));
        }

        for( Long id : dto.getIdJugadores()){
            jugadores.add(jugadorRepository.findById(id).orElseThrow(()-> new RuntimeException("el jugador no existe")));
        }

        Equipo equipo = new Equipo();
        equipo.setNombre(dto.getNombre());
        equipo.setJugadores(jugadores);
        equipo.setTorneo(torneo);
        equipo.setEntrenador(entrenador);


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

    @Override
    public EquipoResponseDto updateEntrenadorAEquipo(Long idEquipo, EquipoRequestDto dto){

        Equipo equipo = equipoRepository.findById(idEquipo).orElseThrow(()-> new usuarioNoEncontradoException("Equipo con el ID: " + idEquipo + " no encontrado"));
        Entrenador entrenador = entrenadorRepository.findById(dto.getEntrenador()).orElseThrow(()-> new RuntimeException("Entrenador no existe"));

        equipo.setEntrenador(entrenador);
        entrenador.setEquipo(equipo);
        Equipo equipoUpdate = equipoRepository.save(equipo);

        return EquipoMapper.toDto(equipoUpdate);

    }

    @Override
    public EquipoResponseDto getEquipoById(Long id){
        Equipo equipo = equipoRepository.findById(id).orElseThrow(()-> new usuarioNoEncontradoException("Equipo con el ID: " + id + " no encontrado"));

        return EquipoMapper.toDto(equipo);
    }

}
