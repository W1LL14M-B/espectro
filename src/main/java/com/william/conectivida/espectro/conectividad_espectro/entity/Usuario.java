package com.william.conectivida.espectro.conectividad_espectro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false, unique = true)
    private String cedula;
    
    @Column(nullable = false, unique = true)
    private String correo;
    
    @Column(name = "num_celular", nullable = false)
    private String numCelular;
    
    @Column(nullable = false, unique = true)
    private String usuario;
    
    @Column(nullable = false)
    private String password;
}
