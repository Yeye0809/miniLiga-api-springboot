package com.yeferson.miniLiga.controller;

import com.yeferson.miniLiga.dto.TorneoRequestDto;
import com.yeferson.miniLiga.dto.TorneoResponseDto;
import com.yeferson.miniLiga.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/torneo")
public class TorneoController {

    @Autowired
    TorneoService torneoService;

    @PostMapping
    public ResponseEntity<TorneoResponseDto> saveTorneo(@RequestBody TorneoRequestDto dto){
        return ResponseEntity.ok(torneoService.saveTorneo(dto));
    }

    @GetMapping
    public ResponseEntity<List<TorneoResponseDto>> getTorneos(){
        return ResponseEntity.ok(torneoService.getTorneos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TorneoResponseDto> updateTorneo(@PathVariable Long id, @RequestBody TorneoRequestDto dto){
        return ResponseEntity.ok(torneoService.updateTorneo(id, dto));
    }
}
