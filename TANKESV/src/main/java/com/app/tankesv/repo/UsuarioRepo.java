package com.app.tankesv.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tankesv.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{

   Optional<Usuario> findByCorreo(String correo);
   Optional<Usuario> findByNombre(String nombre);

}
