package com.app.tankesv.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
    
    private final String name; // Campo adicional para el nombre real del usuario (correo o nombre)
    
    public CustomUserDetails(String email, String password, Collection<? extends GrantedAuthority> authorities, String name) {
        super(email, password, authorities); // Inicializa la clase base (User)
        this.name = name; // Aquí guardamos el nombre real (correo o nombre)
        System.out.println("sistema ejecutandose");
    }

    public String getName() {
        return name; // Retorna el nombre real del usuario
    }
}