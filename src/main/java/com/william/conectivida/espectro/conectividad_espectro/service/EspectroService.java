package com.william.conectivida.espectro.conectividad_espectro.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.william.conectivida.espectro.conectividad_espectro.client.ExternalClient;
import com.william.conectivida.espectro.conectividad_espectro.dto.Dtos;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EspectroService {
    private final ExternalClient externalClient;

    public List<Dtos.Post> obtenerPosts() {
        return externalClient.get("jsonplaceholder", "/posts", new ParameterizedTypeReference<List<Dtos.Post>>() {});
    }

 /*    public Dtos.Pokemon obtenerPokemon(String nombre) {
        return externalClient.get("pokeapi", "/pokemon/" + nombre.toLowerCase(), new ParameterizedTypeReference<Dtos.Pokemon>() {});
    } */
}

