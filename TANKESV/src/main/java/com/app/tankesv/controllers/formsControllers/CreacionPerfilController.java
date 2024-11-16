package com.app.tankesv.controllers.formsControllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.tankesv.model.Creacion_Perfil;
import com.app.tankesv.repo.CreacionPerfilRepo;

import jakarta.validation.Valid;


@Controller
public class CreacionPerfilController {

    @Autowired
    CreacionPerfilRepo creacionPerfilRepo;

    @PostMapping("/CreacionPerfil")
    public String crearPerfil(@Valid @ModelAttribute Creacion_Perfil perfil, 
            BindingResult result,
            @RequestParam("imagen_perfil") MultipartFile imagenPerfil, 
            RedirectAttributes redirectAttributes) {

    // Validar errores de anotaciones de validación
    if (result.hasErrors()) {
        redirectAttributes.addFlashAttribute("message", result.getAllErrors().get(0).getDefaultMessage());
        return "redirect:/CreacionPerfil";
    }
    

    // Validar que las contraseñas coincidan
    if (!perfil.getPassword().equals(perfil.getConfirmPassword())) {
        redirectAttributes.addFlashAttribute("message", "Las contraseñas no coinciden.");
        return "redirect:/CreacionPerfil";
    }

    
    // Validar el formato del teléfono
    if (!perfil.getTelefono().matches("\\d+")) {
        redirectAttributes.addFlashAttribute("message", "El número de teléfono debe contener solo dígitos.");
        return "redirect:/CreacionPerfil";
    }

    // Subir y guardar la imagen de perfil
    if (!imagenPerfil.isEmpty()) {
        try {
            String uploadDir = "C:\\Users\\harol\\Desktop\\TANKESV-PROYECT\\TANKESV\\uploads";
            File uploadPath = new File(uploadDir);

            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            // Guardar la imagen en el directorio "uploads"
            String filePath = uploadDir + "/" + imagenPerfil.getOriginalFilename();
            File file = new File(filePath);
            imagenPerfil.transferTo(file);

            // Guardar la ruta de la imagen en el perfil
            perfil.setFotoPerfil(filePath);

        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Error al subir la imagen.");
            return "redirect:/CreacionPerfil";
        }
    } else {
        redirectAttributes.addFlashAttribute("message", "Por favor, sube una imagen de perfil.");
        return "redirect:/CreacionPerfil";
    }

    // Guardar el perfil en la base de datos
    creacionPerfilRepo.save(perfil);
    redirectAttributes.addFlashAttribute("message", "Perfil creado exitosamente.");
    
    return "redirect:/CreacionPerfil";
}

}
