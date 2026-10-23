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
    public static class Pokemon {
        private String name;
        private int id;
        private Sprites sprites;

        @Data
        public static class Sprites {
            private String front_default;
        }
    }

    /*
     * @Data
     * public static class ApiResponse<T> {
     * private boolean ok = true;
     * private String origen;
     * private T datos;
     * }
     */

    @Data
    public static class ApiResponse<T> {
        private boolean ok = true;
        private String origen = "jsonplaceholder";
        private T datos;
    }
}
