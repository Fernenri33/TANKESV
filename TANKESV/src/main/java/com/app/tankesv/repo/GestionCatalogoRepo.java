package com.app.tankesv.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tankesv.model.Empresario;
import com.app.tankesv.model.GestionCatalogo;

public interface GestionCatalogoRepo extends JpaRepository<GestionCatalogo, Long> {
    List<GestionCatalogo> findByEmpresario(Empresario empresario);
    List<GestionCatalogo> findByNombreProducto(String nombreProducto);
}
