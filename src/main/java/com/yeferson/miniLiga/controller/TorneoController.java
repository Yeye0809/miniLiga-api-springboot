package com.yeferson.miniLiga.controller;

import com.yeferson.miniLiga.dto.TorneoRequestDto;
import com.yeferson.miniLiga.dto.TorneoResponseDto;
import com.yeferson.miniLiga.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/torneo")
public class TorneoController {

    @Autowired
    TorneoService torneoService;

    @PostMapping
    public ResponseEntity<TorneoResponseDto> saveTorneo(@RequestBody TorneoRequestDto dto){
        return ResponseEntity.ok(torneoService.saveTorneo(dto));
    }
}
