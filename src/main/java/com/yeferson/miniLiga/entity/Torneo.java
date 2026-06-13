package com.yeferson.miniLiga.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;
    private String descripción;
    @Future
    private LocalDate fechaInicio;
    @Future
    private LocalDate fechaFin;
    private Boolean activo;

    @OneToMany(mappedBy = "torneo")
    @JsonManagedReference
    private List<Equipo> equipos;

}
