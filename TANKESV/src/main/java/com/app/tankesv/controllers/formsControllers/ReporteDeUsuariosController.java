package com.app.tankesv.controllers.formsControllers;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.tankesv.model.Reporte_Usuario;
import com.app.tankesv.model.Usuario;
import com.app.tankesv.repo.ReporteUsuarioRepo;
import com.app.tankesv.repo.UsuarioRepo;

import org.springframework.ui.Model;

@Controller
public class ReporteDeUsuariosController {

    private Reporte_Usuario reporteUsuario = new Reporte_Usuario();


    public ReporteDeUsuariosController() {
    }

    @Autowired
    UsuarioRepo usuarioRepo;

    @Autowired
    ReporteUsuarioRepo reporteUsuarioRepo;

    @RequestMapping (value = "/ReportarUsuario/{id}", method = RequestMethod.GET)
    public String mostrarformReporteDeUsuariosID(@PathVariable("id") Integer idUsuario, Model model){
        
        //Obteniendo el usuario por el ID
        Optional<Usuario> optionalUsuario = usuarioRepo.findById(idUsuario);
        if(optionalUsuario.isPresent()){

            // Agregando el id del usuario
            int id_usuario = idUsuario;
            reporteUsuario.setidUsuario(id_usuario);

            //Devolviendo el objeto Usuario
            model.addAttribute("Usuario", optionalUsuario.get());
        }

        return "formularios/formReporteDeUsuarios";
    }
    
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
                    File file = new File(filePath);
                    imagenEvidencia.transferTo(file);

                    //Guardar en la base de datos
                    reporteUsuario.setMotivo(motivo);
                    reporteUsuario.setUrlImg(filePath);
                    
                    reporteUsuarioRepo.save(reporteUsuario);
                    
                    // Añadir un mensaje de éxito
                    redirectAttributes.addFlashAttribute("message", "El archivo se ha subido exitosamente.");
                    
                } catch (IOException e) {
                    e.printStackTrace();
                    redirectAttributes.addFlashAttribute("message", "Error al subir el archivo.");
                }
            } else {
                redirectAttributes.addFlashAttribute("message", "Por favor sube una imagen.");
            }
    
            return "redirect:/";
        }
    

}
