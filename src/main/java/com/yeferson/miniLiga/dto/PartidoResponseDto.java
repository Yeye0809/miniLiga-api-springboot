package com.yeferson.miniLiga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartidoResponseDto {
    private Long id;
    private String equipoLocal;
    private String equipoVisitante;
    private Integer golesEquipoLocal;
    private Integer golesEquipoVisitante;
    private LocalDate fecha;
    private Boolean finalizado;
}
