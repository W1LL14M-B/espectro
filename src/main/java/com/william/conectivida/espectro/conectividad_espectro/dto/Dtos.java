package com.william.conectivida.espectro.conectividad_espectro.dto;

import lombok.Data;

public class Dtos {
    @Data
    public static class Post {
        private Long id;
        private Long userId;
        private String title;
        private String body;
    }

    @Data
    public static class ApiResponse<T> {
        private boolean ok = true;
        private String origen = "jsonplaceholder";
        private T datos;
    }
}