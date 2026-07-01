package com.yeferson.miniLiga.exeption;

import com.yeferson.miniLiga.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(usuarioNoEncontradoException.class)
    public ResponseEntity<ErrorResponseDto> usuaioNoEncontrado( usuarioNoEncontradoException e){
        ErrorResponseDto error = new ErrorResponseDto();

        error.setFecha(LocalDateTime.now());
        error.setCodigo(404);
        error.setMensaje(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}
