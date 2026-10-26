package com.william.conectivida.espectro.conectividad_espectro.controller;

//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.william.conectivida.espectro.conectividad_espectro.dto.AuthDtos;
//import com.william.conectivida.espectro.conectividad_espectro.dto.RegistroForm;
//import com.william.conectivida.espectro.conectividad_espectro.repository.UsuarioRepository;
import com.william.conectivida.espectro.conectividad_espectro.service.AuthService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;
    
    @PostMapping("/registro")
    public AuthDtos.AuthResponse registro(@Valid @RequestBody AuthDtos.RegistroRequest req) {
        return authService.registrar(req);
    }
    
    @PostMapping("/login")
    public AuthDtos.AuthResponse login(@Valid @RequestBody AuthDtos.LoginRequest req) {
        return authService.login(req);
    }
}
