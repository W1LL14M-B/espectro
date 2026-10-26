package com.william.conectivida.espectro.conectividad_espectro.exception;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.william.conectivida.espectro.conectividad_espectro.controller.EspectroController;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handle(Exception ex) {
        return ResponseEntity.badRequest().body(Map.of("ok", false, "error", ex.getMessage()));
    }
}
