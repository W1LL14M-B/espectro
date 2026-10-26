package com.william.conectivida.espectro.conectividad_espectro.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.william.conectivida.espectro.conectividad_espectro.dto.AuthDtos;
//import com.william.conectivida.espectro.conectividad_espectro.dto.RegistroForm;
import com.william.conectivida.espectro.conectividad_espectro.entity.Usuario;
import com.william.conectivida.espectro.conectividad_espectro.repository.UsuarioRepository;
import com.william.conectivida.espectro.conectividad_espectro.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    
    public AuthDtos.AuthResponse registrar(AuthDtos.RegistroRequest req) {
        if(repo.existsByUsuario(req.getUsuario())) throw new RuntimeException("Usuario ya existe");
        if(repo.existsByCorreo(req.getCorreo())) throw new RuntimeException("Correo ya registrado");
        if(repo.existsByCedula(req.getCedula())) throw new RuntimeException("Cedula ya registrada");
        
        Usuario user = Usuario.builder()
            .nombre(req.getNombre())
            .cedula(req.getCedula())
            .correo(req.getCorreo())
            .numCelular(req.getNumCelular())
            .usuario(req.getUsuario())
            .password(encoder.encode(req.getPassword()))
            .build();
        repo.save(user);
        
        AuthDtos.AuthResponse res = new AuthDtos.AuthResponse();
        res.setOk(true);
        res.setMensaje("Usuario registrado correctamente");
        res.setUsuario(user.getUsuario());
        return res;
    }
    
    public AuthDtos.AuthResponse login(AuthDtos.LoginRequest req) {
        Usuario user = repo.findByUsuario(req.getUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        if(!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        
        String token = jwtUtil.generarToken(user.getUsuario());
        
        AuthDtos.AuthResponse res = new AuthDtos.AuthResponse();
        res.setOk(true);
        res.setMensaje("Login exitoso");
        res.setToken(token);
        res.setUsuario(user.getUsuario());
        return res;
    }
}
