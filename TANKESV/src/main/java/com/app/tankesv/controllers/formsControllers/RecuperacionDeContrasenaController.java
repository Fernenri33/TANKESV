package com.app.tankesv.controllers.formsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.tankesv.model.Recuperarpassword;
import com.app.tankesv.model.Usuario;
import com.app.tankesv.repo.RecuperarpassworRepo;
import com.app.tankesv.repo.UsuarioRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/RecuperarContrasena")
public class RecuperacionDeContrasenaController {

    @Autowired
    private RecuperarpassworRepo recuperarpassworRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    // Mostrar el formulario de recuperación de contraseña
    @GetMapping
    public String mostrarFormRecuperacionDeContraseña() {
        return "formularios/FormRecuperacionDeContraseña";
    }

    // Procesar la solicitud de recuperación de contraseña
    @PostMapping
    public String procesarRecuperarContraseña(
            @RequestParam("email") String email, 
            RedirectAttributes redirectAttributes) {

        // Buscar el usuario por correo usando streams
        Optional<Usuario> usuarioOpt = usuarioRepo.findAll().stream()
                .filter(usuario -> usuario.getCorreo().equalsIgnoreCase(email))
                .findFirst();

        if (usuarioOpt.isPresent()) {
            Usuario usuarioEncontrado = usuarioOpt.get();

            // Generar un token único para la recuperación
            String token = UUID.randomUUID().toString();

            // Crear y guardar el registro de recuperación
            Recuperarpassword recuperarpassword = new Recuperarpassword();
            recuperarpassword.setIdUsuario(usuarioEncontrado.getId_usuario());

            recuperarpassworRepo.save(recuperarpassword);

            // Enviar un mensaje de éxito al usuario
            redirectAttributes.addFlashAttribute("message", 
                    "Se ha enviado un correo para la recuperación de su contraseña.");
            return "redirect:/RecuperarContrasena/Exito";
        } else {
            // Si el correo no existe, mostrar mensaje de error
            redirectAttributes.addFlashAttribute("error", 
                    "No se encontró una cuenta asociada a ese correo.");
            return "redirect:/RecuperarContrasena/Error";
        }
    }

    // Mostrar la página de éxito
    @GetMapping("/Exito")
    public String mostrarPaginaExito() {
        return "formularios/Exito";
    }

    // Mostrar la página de error
    @GetMapping("/Error")
    public String mostrarPaginaError() {
        return "formularios/Error";
    }
}



 //Escribir en la base de datos el usuario con el correo que el usuario ingrese, Escribir en la tabla recuperar password,recordar usar los repositorios