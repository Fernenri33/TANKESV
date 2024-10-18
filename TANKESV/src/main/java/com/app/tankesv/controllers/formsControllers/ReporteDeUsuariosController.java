package com.app.tankesv.controllers.formsControllers;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ReporteDeUsuariosController {
    
    @GetMapping("/ReportarUsuario")
    public String mostrarformReporteDeUsuarios(){
        return "formularios/formReporteDeUsuarios";
    }

    @Controller
    public class ReporteUsuarioController {
    
        @PostMapping("/ReportarUsuario")
        public String procesarReporteDeUsuarios(
                @RequestParam("nombre_usuario") String nombreUsuario,
                @RequestParam("motivo") String motivo,
                @RequestParam("imagen_evidencia") MultipartFile imagenEvidencia,
                RedirectAttributes redirectAttributes) {
            
            // Guardar archivo en el servidor
            if (!imagenEvidencia.isEmpty()) {
                try {
                    // Directorio donde se guardará la imagen
                    String uploadDir = System.getProperty("user.dir") + "/uploads/";
                    File uploadPath = new File(uploadDir);
    
                    // Crear directorio si no existe
                    if (!uploadPath.exists()) {
                        uploadPath.mkdirs();
                    }
    
                    // Guardar archivo en el directorio
                    String filePath = uploadDir + imagenEvidencia.getOriginalFilename();
                    System.out.print(filePath);
                    File file = new File(filePath);
                    imagenEvidencia.transferTo(file);
                    
                    // Añadir un mensaje de éxito
                    redirectAttributes.addFlashAttribute("message", "El archivo se ha subido exitosamente.");
                    
                } catch (IOException e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("message", "Error al subir el archivo.");
                }
            } else {
                redirectAttributes.addFlashAttribute("message", "Por favor sube una imagen.");
            }
    
            return "redirect:/ReportarUsuario";
        }
    }

}
