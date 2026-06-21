package com.yeferson.miniLiga.controller;

import com.yeferson.miniLiga.dto.EstadisticasDto;
import com.yeferson.miniLiga.service.EstatdisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tabla")
public class EstadisticasController {

    @Autowired
    EstatdisticasService estatdisticasService;

    @GetMapping("/{torneoId}")
    public ResponseEntity<List<EstadisticasDto>> mostrarTabla(@PathVariable Long torneoId){
        return ResponseEntity.ok(estatdisticasService.mostrarEstadisticas(torneoId));
    }

}
