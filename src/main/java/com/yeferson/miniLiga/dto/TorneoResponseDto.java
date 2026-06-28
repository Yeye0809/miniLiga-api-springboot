package com.yeferson.miniLiga.dto;


import com.yeferson.miniLiga.entity.Equipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TorneoResponseDto {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean activo;
    private List<String> equipos;

}
