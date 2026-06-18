package com.yeferson.miniLiga.controller;

import com.yeferson.miniLiga.dto.EntrenadorRequestDto;
import com.yeferson.miniLiga.dto.EntrenadorResponseDto;
import com.yeferson.miniLiga.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenador")
public class EntrenadorController {

    @Autowired
    EntrenadorService entrenadorService;

    @PostMapping
    public ResponseEntity<EntrenadorResponseDto> saveEntrenador(@RequestBody EntrenadorRequestDto dto){
        return ResponseEntity.ok(entrenadorService.saveEntrenador(dto));
    }

    @GetMapping
    public ResponseEntity<List<EntrenadorResponseDto>> getEntrenador(){
        return ResponseEntity.ok(entrenadorService.getEntrenador());
    }

}
