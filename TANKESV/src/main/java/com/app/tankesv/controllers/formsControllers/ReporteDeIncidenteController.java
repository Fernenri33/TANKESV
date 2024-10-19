package com.app.tankesv.controllers.formsControllers;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.tankesv.model.Reporte_Incidente;
import com.app.tankesv.repo.ReporteIncidenteRepo;


@Controller
public class ReporteDeIncidenteController {

    private Reporte_Incidente rIncidente = new Reporte_Incidente();

    @Autowired
    ReporteIncidenteRepo reporteIncidenteRepo;

    @Controller
    public class ReporteIncidenteController {

        @PostMapping("/ReportarIncidente")
        public String procesarReporteDeIncidente(
            @RequestParam("comentariosIncidente") String comentarioIncidente,
            @RequestParam("imagen_evidencia") MultipartFile imagenEvidencia,
            RedirectAttributes redirectAttributes){

                if(!imagenEvidencia.isEmpty())
                {
                    try{
                        String uploadDir = System.getProperty("user.dir") + "/uploads";
                        File uploadPath = new File(uploadDir);

                        if(!uploadPath.exists()){
                            uploadPath.mkdirs();
                        }

                        String filePath = uploadDir + imagenEvidencia.getOriginalFilename();
                        File file = new File(filePath);
                        imagenEvidencia.transferTo(file);

                        rIncidente.setDescripcionProblema(comentarioIncidente);
                        rIncidente.setUrl_img(filePath);

                        reporteIncidenteRepo.save(rIncidente);

                        redirectAttributes.addFlashAttribute("message", "El archivo se ha subido exitosamente");
                    } catch(IOException e)
                    {
                        e.printStackTrace();
                        redirectAttributes.addFlashAttribute("message", "Error al subir el archivo");
                    }
                } else{
                    redirectAttributes.addFlashAttribute("message", "Por favor sube una imagen");
                }

                return "redirect:/ReportarIncidente";
            }        
    }
}
