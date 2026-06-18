package com.yeferson.miniLiga.dto;

import com.yeferson.miniLiga.entity.Equipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntrenadorRequestDto {
    private String nombre;
    private Long equipoId;
}
