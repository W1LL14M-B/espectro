package com.william.conectivida.espectro.conectividad_espectro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.conectivida.espectro.conectividad_espectro.dto.Dtos;
import com.william.conectivida.espectro.conectividad_espectro.service.EspectroService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/espectro")
@RequiredArgsConstructor
public class EspectroController {

    private final EspectroService service;

    @GetMapping("/posts")
    public Dtos.ApiResponse<List<Dtos.Post>> posts() {
        var datos = service.obtenerPosts().subList(0, 10);
        var resp = new Dtos.ApiResponse<List<Dtos.Post>>();
        resp.setOrigen("jsonplaceholder"); 
        resp.setDatos(datos);
        return resp;
    }

    @GetMapping("/pokemon/{nombre}")
    public Dtos.ApiResponse<Dtos.Pokemon> pokemon(@PathVariable String nombre) {
        var datos = service.obtenerPokemon(nombre);
        var resp = new Dtos.ApiResponse<Dtos.Pokemon>();
        resp.setOrigen("pokeapi");
        resp.setDatos(datos);
        return resp;
    }
}

