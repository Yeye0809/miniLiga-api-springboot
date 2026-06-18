package com.yeferson.miniLiga.controller;

import com.yeferson.miniLiga.dto.EquipoRequestDto;
import com.yeferson.miniLiga.dto.EquipoResponseDto;
import com.yeferson.miniLiga.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    @Autowired
    EquipoService equipoService;

    @PostMapping
    public ResponseEntity<EquipoResponseDto> saveJugaor(@RequestBody EquipoRequestDto dto){
        return ResponseEntity.ok(equipoService.saveEquipo(dto));
    }

    @GetMapping
    public ResponseEntity<List<EquipoResponseDto>> getEquipos(){
        return ResponseEntity.ok(equipoService.getEquipos());
    }

}
