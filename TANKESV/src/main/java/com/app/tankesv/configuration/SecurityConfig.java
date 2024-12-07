package com.app.tankesv.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.app.tankesv.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            // Permitir acceso sin autenticación
            .requestMatchers("/", "/css/**", "/js/**", "/img/**","/neue-machina/**","/CreacionPerfil/**").permitAll()
            
            // Acceso exclusivo para ROLE_EMPRESARIO
            .requestMatchers(
                "/editCrowdfunding", 
                "/AgregarCatalogo", 
                "/ListaCatalogo", 
                "/EditarCatalogo/{id}", 
                "/EliminarCatalogo/{id}",
                "/editCrowdfunding/{id}",
                "/MisCrowdfundings",
                "/Pago/{id}",
                "/ListaCatalogo"
            ).hasRole("EMPRESARIO")

            // Acceso exclusivo para ROLE_USUARIO
            .requestMatchers("/Pago/{id}").hasRole("USER")
            
            // Otras rutas requieren autenticación
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/Login")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/homeUsuario", true)
            .failureUrl("/Login?error=true")
            .usernameParameter("email")
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/Login")
            .permitAll()
        );

    return http.build();
}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder = 
        http.getSharedObject(AuthenticationManagerBuilder.class);

    authenticationManagerBuilder
        .userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());

    return authenticationManagerBuilder.build();
}
}



