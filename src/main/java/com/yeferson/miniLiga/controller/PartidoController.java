package com.yeferson.miniLiga.controller;

import com.yeferson.miniLiga.dto.PartidoRequestDto;
import com.yeferson.miniLiga.dto.PartidoResponseDto;
import com.yeferson.miniLiga.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partido")
public class PartidoController {

    @Autowired
    PartidoService partidoService;

    @PostMapping
    public ResponseEntity<PartidoResponseDto> savePartido(@RequestBody PartidoRequestDto dto){
        return ResponseEntity.ok(partidoService.savePartido(dto));
    }

    @GetMapping
    public ResponseEntity<List<PartidoResponseDto>> getPartidos(){
        return ResponseEntity.ok(partidoService.getPartidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoResponseDto> getPartidoByID(@PathVariable Long id){
        return ResponseEntity.ok(partidoService.getPartidoById(id));
    }

    @PatchMapping("/resultado/{id}")
    public ResponseEntity<PartidoResponseDto> updateFinalPartido(@PathVariable Long id, @RequestBody PartidoRequestDto dto ){
        return ResponseEntity.ok(partidoService.updateFinalPartido(id, dto));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PartidoResponseDto> updatePartido(@PathVariable Long id, @RequestBody PartidoRequestDto dto){
        return ResponseEntity.ok(partidoService.updatePartido(id,dto));
    }

}
