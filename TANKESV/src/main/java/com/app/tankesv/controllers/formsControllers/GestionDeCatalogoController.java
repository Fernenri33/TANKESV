package com.app.tankesv.controllers.formsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.tankesv.repo.GestionCatalogoRepo;
import com.app.tankesv.service.GestionCatalogoService;

@Controller
public class GestionDeCatalogoController {

    @Autowired
    GestionCatalogoService gestionCatalogoService;
    @Autowired
    GestionCatalogoRepo gestionCatalogoRepo;

    @GetMapping("/GestionCatalogo")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("gestion_catalogos", gestionCatalogoService.obtenerCatalogo());
        return "formularios/formGestionCatalogos";
    }
    
    @PostMapping("/GestionCatalogo")
public String procesarGestionCatalogo(
    @RequestParam(value = "id", required = false) Integer id,  // Hacer id opcional
    @RequestParam("nombreProducto") String nombreProducto,
    @RequestParam("descripcionProducto") String descripcionProducto,
    @RequestParam(value = "precioProducto", required=false) double precioProducto,
    @RequestParam(value = "cantidadProducto", required = false) int cantidadProducto,
    @RequestParam("imagenProducto") MultipartFile imagenProducto,
    @RequestParam("action") String action, // Detectar qué botón se presionó
    RedirectAttributes redirectAttributes) {

    try {
        switch (action) {
            case "Agregar":
                gestionCatalogoService.agregarProducto(nombreProducto, descripcionProducto, precioProducto, cantidadProducto, imagenProducto, redirectAttributes);
                break;

            case "Actualizar":
                // Verificar que id no sea null antes de actualizar
                gestionCatalogoService.actualizarProducto(cantidadProducto, nombreProducto, descripcionProducto, precioProducto, cantidadProducto, imagenProducto, redirectAttributes);
                break;

            case "Eliminar":
                // Verificar que id no sea null antes de eliminar
                if (id == null) {
                    redirectAttributes.addFlashAttribute("message", "ID del producto es requerido para eliminar.");
                    return "redirect:/GestionCatalogo";
                }
                gestionCatalogoService.eliminarProducto(id, redirectAttributes);
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

