package com.app.tankesv.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.tankesv.model.Creacion_Perfil;



@Repository
public interface CreacionPerfilRepo extends JpaRepository<Creacion_Perfil, Long> {

    Creacion_Perfil findByCorreo(String correo); 
}
