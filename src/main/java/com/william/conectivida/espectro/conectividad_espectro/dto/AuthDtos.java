package com.william.conectivida.espectro.conectividad_espectro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class AuthDtos {
    
    @Data
    public static class RegistroRequest {
        @NotBlank(message = "Nombre obligatorio")
        private String nombre;
        
        @NotBlank
        @Pattern(regexp = "^[0-9]{6,15}$", message = "Cedula solo numeros, 6-15 digitos")
        private String cedula;
        
        @NotBlank @Email
        private String correo;
        
        @NotBlank
        @Pattern(regexp = "^[0-9]{10}$", message = "Celular 10 digitos")
        private String numCelular;
        
        @NotBlank @Size(min = 4, max = 20)
        private String usuario;
        
        @NotBlank @Size(min = 6, message = "Contraseña min 6 caracteres")
        private String password;
    }
    
    @Data
    public static class LoginRequest {
        @NotBlank
        private String usuario;
        @NotBlank
        private String password;
    }
    
    @Data
    public static class AuthResponse {
        private boolean ok;
        private String mensaje;
        private String token;
        private String usuario;
    }
}

