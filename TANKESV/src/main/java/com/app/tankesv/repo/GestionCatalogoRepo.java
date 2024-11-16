package com.app.tankesv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tankesv.model.GestionCatalogo;

public interface GestionCatalogoRepo extends JpaRepository<GestionCatalogo, Integer> {
    
}
