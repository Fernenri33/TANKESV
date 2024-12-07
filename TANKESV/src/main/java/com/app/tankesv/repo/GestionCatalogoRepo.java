package com.app.tankesv.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tankesv.model.Empresario;
import com.app.tankesv.model.GestionCatalogo;

public interface GestionCatalogoRepo extends JpaRepository<GestionCatalogo, Long> {

    // Buscar productos asociados a un empresario
    List<GestionCatalogo> findByEmpresario(Empresario empresario);

    // Buscar productos por coincidencia parcial en el nombre (ignorar mayúsculas/minúsculas)
    List<GestionCatalogo> findByNombreProductoContainingIgnoreCase(String nombreProducto);
}
