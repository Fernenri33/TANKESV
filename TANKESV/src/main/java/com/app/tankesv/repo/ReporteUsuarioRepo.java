package com.app.tankesv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tankesv.model.Reporte_Usuario;

public interface ReporteUsuarioRepo extends JpaRepository<Reporte_Usuario, Integer> {
    
}
