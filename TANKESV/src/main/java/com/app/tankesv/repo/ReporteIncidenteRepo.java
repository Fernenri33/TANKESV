package com.app.tankesv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.tankesv.model.Reporte_Incidente;

public interface ReporteIncidenteRepo extends JpaRepository<Reporte_Incidente, Integer> {
} 
