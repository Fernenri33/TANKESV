package com.app.tankesv.controllers.formsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.tankesv.service.GestionCatalogoService;

@Controller
public class productoController {

    @Autowired
    private GestionCatalogoService gestionCatalogoService;

    // Método para ver los productos en el catálogo
    @GetMapping("/Producto")
    public String verProducto(
            @RequestParam(value = "nombreProducto", required = false) String nombreProducto,
            Model model) {

        if (nombreProducto != null && !nombreProducto.isEmpty()) {
            // Buscar productos por nombre si se proporciona un parámetro de búsqueda
            model.addAttribute("productos", gestionCatalogoService.obtenerProductoNombre(nombreProducto));
        } else {
            // Mostrar todos los productos si no hay búsqueda
            model.addAttribute("productos", gestionCatalogoService.obtenerCatalogoUsuario());
        }

        return "gestionDeCatalogos/buscarProducto"; // Nombre de la vista HTML
    }
}

