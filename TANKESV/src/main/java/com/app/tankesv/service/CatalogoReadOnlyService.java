package com.app.tankesv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.tankesv.model.GestionCatalogo;
import com.app.tankesv.repo.GestionCatalogoRepo;

@Service
public class CatalogoReadOnlyService {

    @Autowired
    GestionCatalogoRepo gestionCatalogoRepo;

    // Obtener todos los productos del catálogo
    public List<GestionCatalogo> obtenerCatalogo() {
        List<GestionCatalogo> catalogos = gestionCatalogoRepo.findAll();
        return catalogos != null ? catalogos : new ArrayList<>();
    }
}
