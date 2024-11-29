package com.app.tankesv.controllers.formsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.app.tankesv.service.GestionCatalogoService;

@Controller
public class GestionDeCatalogoController {

    @Autowired
    GestionCatalogoService gestionCatalogoService;

    @PostMapping("/GestionCatalogo")
    public String procesarGestionCatalogo(
        @RequestParam("nombreProducto") String nombreProducto,
        @RequestParam("descripcionProducto") String descripcionProducto,
        @RequestParam("precioProducto") double precioProducto,
        @RequestParam("cantidadProducto") int cantidadProducto,
        @RequestParam("imagenProducto") MultipartFile imagenProducto,
        @RequestParam("action") String action, // Detectar qué botón se presionó
        RedirectAttributes redirectAttributes) {

        try {
            switch (action) {
                case "Agregar":
                    gestionCatalogoService.agregarProducto(nombreProducto, descripcionProducto, precioProducto, cantidadProducto, imagenProducto, redirectAttributes);
                    break;

                case "Actualizar":
                    gestionCatalogoService.actualizarProducto(nombreProducto, descripcionProducto, precioProducto, cantidadProducto, imagenProducto, redirectAttributes);
                    break;

                case "Eliminar":
                    gestionCatalogoService.eliminarProducto(nombreProducto, redirectAttributes);
                    break;

                default:
                    redirectAttributes.addFlashAttribute("message", "Acción no reconocida.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/GestionCatalogo";
    }
}

