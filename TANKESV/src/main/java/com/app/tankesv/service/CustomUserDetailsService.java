package com.app.tankesv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.tankesv.model.Usuario;
import com.app.tankesv.repo.EmpresarioRepository;
import com.app.tankesv.repo.UsuarioRepo;
import com.app.tankesv.security.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private EmpresarioRepository empresarioRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Inicio de sesión detectado para: " + email);
        
        // Busca al usuario en la base de datos
        Usuario usuario = usuarioRepo.findByCorreo(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Verifica si el usuario pertenece a la tabla empresario
        boolean isEmpresario = empresarioRepo.existsByUsuario_IdUsuario(usuario.getId_usuario());

        // Crea y retorna un objeto CustomUserDetails con la información necesaria
        return new CustomUserDetails(
            usuario.getCorreo(),
            usuario.getPassword(),
            List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRole().toUpperCase())),
            usuario.getNombre(),
            isEmpresario
        );
    }
}
