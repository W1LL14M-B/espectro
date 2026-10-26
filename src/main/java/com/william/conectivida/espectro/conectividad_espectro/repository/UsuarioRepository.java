package com.william.conectivida.espectro.conectividad_espectro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.william.conectivida.espectro.conectividad_espectro.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String usuario);
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByCedula(String cedula);
    Boolean existsByUsuario(String usuario);
    Boolean existsByCorreo(String correo);
    Boolean existsByCedula(String cedula);
}
