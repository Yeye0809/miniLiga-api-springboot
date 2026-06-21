package com.yeferson.miniLiga.service;

import com.yeferson.miniLiga.dto.EstadisticasDto;
import com.yeferson.miniLiga.entity.Equipo;
import com.yeferson.miniLiga.entity.Partido;
import com.yeferson.miniLiga.repository.EquipoRepository;
import com.yeferson.miniLiga.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class EstadisticasServiceImpl implements EstatdisticasService {

    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    PartidoRepository partidoRepository;


    public List<EstadisticasDto> mostrarEstadisticas(Long torneoId){
        List<Equipo> equipos = equipoRepository.findByTorneoId(torneoId);
        List<Partido> partidos = partidoRepository.findByTorneoIdAndFinalizadoTrue(torneoId);

        List<EstadisticasDto> tabla = new ArrayList<>();

        for( Equipo equipo : equipos ){
           EstadisticasDto dto =  calcularEstadisticas(equipo, partidos);

           tabla.add(dto);
        }

         tabla.sort(Comparator.comparing(EstadisticasDto::getPuntos).reversed()
                    .thenComparing(Comparator.comparing(EstadisticasDto::getGf).reversed()));

        return tabla;

    }

    private EstadisticasDto calcularEstadisticas(Equipo equipo, List<Partido> partidos){

        EstadisticasDto dto = new EstadisticasDto();

        dto.setEquipo(equipo.getNombre());

        for (Partido partido : partidos ){

            boolean esLocal = partido.getEquipoLocal().getId().equals(equipo.getId());
            boolean esVisitante = partido.getEquipoVisitante().getId().equals(equipo.getId());

            if( !esLocal && !esVisitante ){
                continue;
            }

            dto.setPj(dto.getPj() + 1);

            int golFavor;
            int golContra;

            if (esLocal){
                golFavor = partido.getGolesEquipoLocal();
                golContra = partido.getGolesEquipoVisitante();
            }else{
                golFavor = partido.getGolesEquipoVisitante();
                golContra = partido.getGolesEquipoLocal();
            }

            dto.setGf( dto.getGf() + golFavor);
            dto.setGc(dto.getGc() + golContra);

            if( golFavor > golContra){
                dto.setPg(dto.getPg() + 1);
                dto.setPuntos( dto.getPuntos() + 3);

            }else if( golFavor == golContra){
                dto.setPe(dto.getPe() + 1);
                dto.setPuntos(dto.getPuntos() + 1);

            }else{
                dto.setPp(dto.getPp() + 1);
            }

        }
        return dto;
    }

}
