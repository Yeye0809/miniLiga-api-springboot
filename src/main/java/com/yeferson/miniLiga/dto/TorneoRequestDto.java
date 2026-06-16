package com.yeferson.miniLiga.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TorneoRequestDto {

    @NotBlank
    private String nombre;
    private String descripcion;
    @Future
    private LocalDate fechaInicio;
    @Future
    private LocalDate fechaFin;

}
