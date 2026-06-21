package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.EstadisticasDto;
import com.yeferson.miniLiga.entity.Equipo;
import com.yeferson.miniLiga.entity.Partido;
import com.yeferson.miniLiga.repository.EquipoRepository;
import com.yeferson.miniLiga.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadisticasServiceImpl implements EstatdisticasService {

    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    PartidoRepository partidoRepository;


    public List<EstadisticasDto> mostrarEstadisticas(Long torneoId){
        List<Equipo> equipos = equipoRepository.findByTorneoId(torneoId);
        List<Partido> partidos = partidoRepository.findBy;

        List<EstadisticasDto> tabla = new ArrayList<>();

        for( Equipo equipo : equipos ){
           EstadisticasDto dto =  calcularEstadisticas(equipo, partidos);

           tabla.add(dto);
        }

    }

    private EstadisticasDto calcularEstadisticas(Equipo equipo, List<Partido> partidos){




    }

}
