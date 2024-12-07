package com.app.tankesv.controllers.formsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.tankesv.service.GestionCatalogoService;

@Controller
public class productoController {

    @Autowired
    private GestionCatalogoService gestionCatalogoService;

    // Método para ver los productos en el catálogo
    @GetMapping("/Producto")
    public String verProducto( Model model, String nombreProoducto) {
        // Obtener todos los productos
        model.addAttribute("productos", gestionCatalogoService.obtenerCatalogoUsuario());
        return "gestionDeCatalogos/buscarProducto"; // Vista para mostrar los productos
    }
}
