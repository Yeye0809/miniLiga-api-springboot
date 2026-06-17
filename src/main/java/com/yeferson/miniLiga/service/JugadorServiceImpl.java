package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.JugadorRequestDto;
import com.yeferson.miniLiga.dto.JugadorResponseDto;
import com.yeferson.miniLiga.entity.Jugador;
import com.yeferson.miniLiga.mapper.JugadorMapper;
import com.yeferson.miniLiga.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceImpl implements JugadorService{

    @Autowired
    JugadorRepository jugadorRepository;

    @Override
    public JugadorResponseDto saveJugador(JugadorRequestDto dto){

        Jugador jugador = new Jugador();
        jugador.setNombre(dto.getNombre());
        jugador.setPosicion(dto.getPosicion());
        jugador.setNumeroCamisa(dto.getNumeroCamisa());

        if(dto.getEquipo() != null ){
            jugador.setEquipo(dto.getEquipo());
        }

        Jugador jugadorSave = jugadorRepository.save(jugador);

        return JugadorMapper.toDto(jugadorSave);
    }

    @Override
    public List<JugadorResponseDto> getJugadores() {
         return jugadorRepository.findAll().stream().map(JugadorMapper::toDto).toList();
    }
}
