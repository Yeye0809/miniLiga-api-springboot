package com.yeferson.miniLiga.exeption;

public class usuarioNoEncontradoException extends RuntimeException{

    public usuarioNoEncontradoException( String mensaje ){
        super(mensaje);
    }
}
