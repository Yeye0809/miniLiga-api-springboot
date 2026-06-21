package com.yeferson.miniLiga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticasDto {
    private String equipo;
    private int puntos;
    private int pj;
    private int pg;
    private int pp;
    private int pe;
    private int gf;
    private int gc;

}
