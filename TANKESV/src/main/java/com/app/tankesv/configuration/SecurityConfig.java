package com.app.tankesv.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Definir el PasswordEncoder como un bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usando BCrypt para encriptar contraseñas
    }

    // Configuración de seguridad (ya la habíamos visto antes)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll() // Permitir acceso a todas las rutas sin restricciones
            )
            .csrf(csrf -> csrf.disable()) // Opcional: Deshabilitar CSRF para desarrollo
            .formLogin(form -> form.disable()) // Deshabilitar el formulario de login predeterminado
            .httpBasic(httpBasic -> httpBasic.disable()); // Deshabilitar autenticación básica predeterminada

        return http.build();
    }
}


