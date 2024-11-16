package com.app.tankesv.controllers.crowdfundingControllers;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.tankesv.model.Crowdfunding;
import com.app.tankesv.model.CrowdfundingImg;
import com.app.tankesv.repo.CrowdfundingImgRepo;
import com.app.tankesv.repo.CrowdfundingRepo;

@Controller
public class CrowdfundingController {

    @Autowired CrowdfundingRepo crowdfundingRepo;
    @Autowired CrowdfundingImgRepo crowdfundingImgRepo;

    @GetMapping("/editCrowdfunding")
    public String mostrarCrowdfunding(){
        return "crowdfunding/editcrowdfunding";
    }

    @PostMapping("/editCrowdfunding")
    public String guardarCrowdfunding(
            @RequestParam("nombreProyecto") String nombreProyecto,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("metaMonetaria") BigDecimal metaMonetaria,
            @RequestParam("formFileMultiple") MultipartFile[] files
    ) {

        // Crear una nueva instancia de Crowdfunding y asignar valores
        Crowdfunding crowdfunding = new Crowdfunding();
        crowdfunding.setTitulo(nombreProyecto);
        crowdfunding.setDescripcion(descripcion);
        crowdfunding.setMeta(metaMonetaria);
        crowdfunding.setRecaudado(BigDecimal.ZERO);  // Asumiendo que inicia en 0

        // Guardar la instancia de Crowdfunding en la base de datos
        crowdfunding = crowdfundingRepo.save(crowdfunding);

        // Lista para almacenar las imágenes relacionadas
        List<CrowdfundingImg> imagenes = new ArrayList<>();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                // Aquí podrías guardar el archivo en el sistema de archivos y obtener la URL o en una base de datos
                String url = almacenarArchivo(file); // Método para almacenar el archivo y obtener la URL
                
                // Crear una instancia de CrowdfundingImg
                CrowdfundingImg crowdfundingImg = new CrowdfundingImg();
                crowdfundingImg.setUrlImg(url);
                crowdfundingImg.setCrowdfunding(crowdfunding); // Asignar el proyecto de crowdfunding

                // Guardar cada imagen en la base de datos
                crowdfundingImgRepo.save(crowdfundingImg);

                // Añadir a la lista de imágenes
                imagenes.add(crowdfundingImg);
            }
        }

        // Asignar la lista de imágenes al proyecto y guardar nuevamente
        crowdfunding.setImagenes(new HashSet<>(imagenes));
        crowdfundingRepo.save(crowdfunding);

        return "redirect:/editCrowdfunding"; // Redirigir o mostrar mensaje de éxito
    }

    private String almacenarArchivo(MultipartFile file) {
        // Directorio base donde guardaremos los archivos
        String uploadDir = System.getProperty("user.dir") + "/uploads/";
        File uploadPath = new File(uploadDir);

        // Crear el directorio si no existe
        if (!uploadPath.exists()) {
        uploadPath.mkdirs();
        }

        // Obtener el nombre original del archivo
        String fileName = file.getOriginalFilename();

        // Definir la ruta completa del archivo donde será guardado
        String filePath = uploadDir + File.separator + fileName;
        File destinationFile = new File(filePath);

        try {
            // Guardar el archivo en el directorio especificado
            file.transferTo(destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;  // En caso de error, retorna null o maneja la excepción según necesites
        }

    // Retornar la URL del archivo guardado
    // Puedes retornar el path relativo si necesitas acceder desde un servidor de archivos o directamente el path
    return "/uploads/" + fileName;
}
}
