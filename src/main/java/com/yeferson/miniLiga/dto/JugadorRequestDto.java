package com.yeferson.miniLiga.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yeferson.miniLiga.entity.Equipo;
import com.yeferson.miniLiga.enums.Posicion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JugadorRequestDto {

    private String nombre;
    private Long numeroCamisa;
    private Posicion posicion;
    private Equipo equipo;

}
