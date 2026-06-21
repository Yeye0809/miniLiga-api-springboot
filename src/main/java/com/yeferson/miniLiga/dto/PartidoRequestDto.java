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
public class PartidoRequestDto {
    private Long equipoLocal;
    private Long equipoVisitante;
    private Integer golesEquipoLocal;
    private Integer golesEquipoVisitante;
    private LocalDate fecha;

}
