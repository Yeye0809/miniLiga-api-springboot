package com.yeferson.miniLiga.controller;

import com.yeferson.miniLiga.dto.JugadorRequestDto;
import com.yeferson.miniLiga.dto.JugadorResponseDto;
import com.yeferson.miniLiga.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugador")
public class JugadorController {

    @Autowired
    JugadorService jugadorService;

    @PostMapping
    public ResponseEntity<JugadorResponseDto> saveJagadoe(@RequestBody JugadorRequestDto jugador){
        return ResponseEntity.ok(jugadorService.saveJugador(jugador));
    }

    @GetMapping
    public ResponseEntity<List<JugadorResponseDto>> getJugadores(){
        return ResponseEntity.ok(jugadorService.getJugadores());
    }

}
