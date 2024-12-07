package com.app.tankesv.controllers.formsControllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.tankesv.model.Usuario;
import com.app.tankesv.repo.UsuarioRepo;

import jakarta.validation.Valid;



@Controller
public class CreacionPerfilController {

    @Autowired
    UsuarioRepo usuariorepo;

    @Autowired
    PasswordEncoder passwordEncoder;
    
        // Directorio para guardar las imágenes
        private static final String UPLOAD_DIR = "tankesv/src/main/resources/static/uploads/";
    
        @PostMapping("/CreacionPerfil")
        public String crearPerfil(@Valid @ModelAttribute Usuario perfil, 
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
    
            // Cifrar la contraseña
            perfil.setPassword(passwordEncoder.encode(perfil.getPassword()));
    
            // Asignar rol por defecto
            perfil.setRole("ROLE_USER");
    
            // Manejo de la imagen de perfil
            if (!imagenPerfil.isEmpty()) {
                try {
                    // Crear el directorio si no existe
                    Path uploadPath = Paths.get(UPLOAD_DIR);
                    if (Files.notExists(uploadPath)) {
                        Files.createDirectories(uploadPath);
                    }
    
                    // Generar un nombre único para el archivo
                    String fileName = UUID.randomUUID() + "_" + imagenPerfil.getOriginalFilename();
    
                    // Guardar el archivo en el directorio
                    Path filePath = uploadPath.resolve(fileName);
                    Files.copy(imagenPerfil.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
    
                    // Guardar la ruta relativa del archivo
                    perfil.setFotoPerfil("uploads/" + fileName);
    
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
            usuariorepo.save(perfil);
            redirectAttributes.addFlashAttribute("message", "Perfil creado exitosamente.");
            return "redirect:/Login";
        }
    }


    