package com.app.tankesv.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
    
    private final String name; // Campo adicional para el nombre real del usuario (correo o nombre)
    private final boolean isEmpresario;

    public CustomUserDetails(String email, String password, Collection<? extends GrantedAuthority> authorities, String name, boolean isEmpresario) {
        super(email, password, authorities);
        this.name = name;
        this.isEmpresario = isEmpresario;
    }

    public String getName() {
        return name; // Retorna el nombre real del usuario
    }

    public boolean isEmpresario() {
        return isEmpresario;
    }
    
}