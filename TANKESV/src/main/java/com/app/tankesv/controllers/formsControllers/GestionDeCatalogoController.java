package com.app.tankesv.controllers.formsControllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.tankesv.model.Empresario;
import com.app.tankesv.model.GestionCatalogo;
import com.app.tankesv.repo.EmpresarioRepository;
import com.app.tankesv.repo.GestionCatalogoRepo;
import com.app.tankesv.service.GestionCatalogoService;

@Controller
public class GestionDeCatalogoController {

    @Autowired
    GestionCatalogoService gestionCatalogoService;
    @Autowired
    GestionCatalogoRepo gestionCatalogoRepo;
    @Autowired 
    EmpresarioRepository empresarioRepository;


    // Mostrar Formulario Agregar Catalogo
    @GetMapping("/AgregarCatalogo")
    public String agregarCatalogo(){
        return "gestionDeCatalogos/formAgregarCatalogo";
    }

    // Mostrar Formulario Listado del Catalogox
    @GetMapping("/ListaCatalogo")
    public String listaCatalogo(Model model, Principal principal) {
        // Obtener el email del usuario autenticado
        String email = principal.getName();
    
        // Buscar al empresario por su correo
        Empresario empresario = empresarioRepository.findByUsuarioCorreo(email)
            .orElseThrow(() -> new IllegalStateException("El usuario no está registrado como empresario"));
    
        // Obtener los productos asociados al empresario
        List<GestionCatalogo> productos = gestionCatalogoService.obtenerCatalogo(empresario);
    
        // Pasar la lista de productos al modelo
        model.addAttribute("gestion_catalogos", productos);
    
        return "gestionDeCatalogos/formListaCatalogo";
    }
    

    // Agregar un producto al catálogo
    @PostMapping("/AgregarCatalogo")
    public String agregarCatalogo(@RequestParam String nombreProducto, @RequestParam String descripcionProducto,
                                      @RequestParam double precioProducto, @RequestParam int cantidadProducto,
                                      @RequestParam MultipartFile imagenProducto, Principal principal, RedirectAttributes redirectAttributes) throws IOException {

        String email = principal.getName();

        Empresario empresario = empresarioRepository.findByUsuarioCorreo(email)
        .orElseThrow(() -> new IllegalStateException("El usuario no está registrado como empresario"));
        
        gestionCatalogoService.agregarProducto(nombreProducto, descripcionProducto, precioProducto, cantidadProducto, imagenProducto, empresario, redirectAttributes);
        return "redirect:/ListaCatalogo";
    }

    // Mostrar el formulario de Editar Catalogo
    @GetMapping("/EditarCatalogo/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
        model.addAttribute("gestion_catalogo", gestionCatalogoService.obtenerProductoID(id));
        return "gestionDeCatalogos/formEditarCatalogo";
    }

    // Enviar la actualización
    @PostMapping("/EditarCatalogo/{id}")
    public String actualizarCatalogo(@PathVariable("id") Long id, @RequestParam String nombreProducto, 
        @RequestParam String descripcionProducto, @RequestParam double precioProducto, @RequestParam int cantidadProducto, 
        @RequestParam MultipartFile imagenProducto) throws IOException {

            gestionCatalogoService.editarProducto(id, nombreProducto, descripcionProducto, precioProducto, cantidadProducto, imagenProducto, null);
        return "redirect:/ListaCatalogo";
    }

    // Eliminar un producto del catalogo
    @PostMapping("/EliminarCatalogo/{id}")
    public String eliminarProducto(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) throws IOException {
        gestionCatalogoService.eliminarProducto(id, redirectAttributes);
        return "redirect:/ListaCatalogo";
    }

}

