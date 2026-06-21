package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.PartidoRequestDto;
import com.yeferson.miniLiga.dto.PartidoResponseDto;
import com.yeferson.miniLiga.entity.Equipo;
import com.yeferson.miniLiga.entity.Partido;
import com.yeferson.miniLiga.entity.Torneo;
import com.yeferson.miniLiga.mapper.PartidoMapper;
import com.yeferson.miniLiga.repository.EquipoRepository;
import com.yeferson.miniLiga.repository.PartidoRepository;
import com.yeferson.miniLiga.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoServiceImpl implements PartidoService{

    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    PartidoRepository partidoRepository;

    @Autowired
    TorneoRepository torneoRepository;

    @Override
    public PartidoResponseDto savePartido(PartidoRequestDto dto){

        Equipo equipoLocal = equipoRepository.findById(dto.getEquipoLocal()).orElseThrow(()-> new RuntimeException("equipo no encontrado"));
        Equipo equipoVisitante = equipoRepository.findById(dto.getEquipoVisitante()).orElseThrow(()-> new RuntimeException("equipo no encontrado"));
        Torneo torneo = torneoRepository.findById(dto.getTorneoId()).orElseThrow(()-> new RuntimeException("torneo no encontrado"));
        Partido partido = new Partido();

        partido.setTorneo(torneo);
        partido.setEquipoLocal(equipoLocal);
        partido.setEquipoVisitante(equipoVisitante);
        partido.setFecha(dto.getFecha());
        partido.setFinalizado(false);

        Partido partidoSave = partidoRepository.save(partido);

        return PartidoMapper.toDto(partidoSave);

    }

    @Override
    public List<PartidoResponseDto> getPartidos(){
        return partidoRepository.findAll().stream().map(PartidoMapper::toDto).toList();
    }

    @Override
    public PartidoResponseDto getPartidoById(Long id){
        Partido partido = partidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Partido no encontrado"));
        return PartidoMapper.toDto(partido);
    }

    @Override
    public  PartidoResponseDto updateFinalPartido(Long id, PartidoRequestDto dto ){
        Partido partido = partidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Partido no encontrado"));

        if( dto.getFecha() != null ){
            partido.setFecha(dto.getFecha());
        }

        if( dto.getGolesEquipoLocal() != null){
            partido.setGolesEquipoLocal(dto.getGolesEquipoLocal());
        }

        if( dto.getGolesEquipoVisitante() != null ){
            partido.setGolesEquipoVisitante(dto.getGolesEquipoVisitante());
        }

        partido.setFinalizado(true);

        Partido partidoUpdate = partidoRepository.save(partido);

        return PartidoMapper.toDto(partidoUpdate);

    }

    @Override
    public PartidoResponseDto updatePartido(Long id, PartidoRequestDto dto ){
        Partido partido = partidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Partido no encontrado"));

        Equipo equipoLocal = equipoRepository.findById(dto.getEquipoLocal()).orElseThrow(()-> new RuntimeException("equipo no encontrado"));
        Equipo equipoVisitante = equipoRepository.findById(dto.getEquipoVisitante()).orElseThrow(()-> new RuntimeException("equipo no encontrado"));

        if( dto.getEquipoVisitante() != null ){
            partido.setEquipoVisitante(equipoVisitante);
        }

        if( dto.getEquipoLocal() != null){
            partido.setEquipoLocal(equipoLocal);
        }

        if( dto.getFecha() != null ){
            partido.setFecha(dto.getFecha());
        }

        Partido partidoUpdate = partidoRepository.save(partido);

        return PartidoMapper.toDto(partidoUpdate);

    }

}
