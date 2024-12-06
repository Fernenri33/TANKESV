package com.app.tankesv.repo;

import com.app.tankesv.model.Empresario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresarioRepository extends JpaRepository<Empresario, Integer> {
    boolean existsByUsuario_IdUsuario(int usuarioId);

    Optional<Empresario> findByUsuarioCorreo(String correo);
}
