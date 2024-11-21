package com.app.tankesv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tankesv.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{

   Usuario findByCorreo(String correo);

}
