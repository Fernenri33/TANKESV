package com.app.tankesv.controllers.formsControllers;

import java.io.File;
import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.tankesv.model.GestionCatalogo;

@Controller
public class GestionDeCatalogoController {

    private GestionCatalogo gCatalogo = new GestionCatalogo();

    @PostMapping("/GestionCatalogo")
    public String procesarGestionCatalogo(
        @RequestParam("nombreProducto") String nombreProducto,
        @RequestParam("descripcionProducto") String descripcionProducto,
        @RequestParam("precioProducto") double precioProducto,
        @RequestParam("cantidadProducto") int cantidadProducto,
        @RequestParam("imagenProducto") MultipartFile imagenProducto,
        RedirectAttributes redirectAttributes){

            if(!imagenProducto.isEmpty())
            {
                String uploadDir = System.getProperty("user.dir") + "/uploads";
                File uploadPath = new File(uploadDir);

                if(!uploadPath.exists()) {
                    uploadPath.mkdirs();
                }

                
            }


            return "redirect:/GestionCatalogo";
        }
    
}
