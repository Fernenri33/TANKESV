package com.app.tankesv.controllers.crowdfundingControllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.app.tankesv.model.Crowdfunding;
import com.app.tankesv.model.Empresario;
import com.app.tankesv.repo.CrowdfundingRepo;
import com.app.tankesv.repo.EmpresarioRepository;
import com.app.tankesv.repo.UsuarioRepo;
import com.app.tankesv.service.crowdfundingService.CrowdfundingService;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
public class CrowdfundingController {

    @Autowired CrowdfundingRepo crowdfundingRepo;
    @Autowired CrowdfundingService crowdfundingService;
    @Autowired UsuarioRepo usuarioRepo;
    @Autowired EmpresarioRepository empresarioRepository;

    @GetMapping("/editCrowdfunding")
    public String mostrarCrowdfunding(){
        return "crowdfunding/editcrowdfunding";
    }

    @GetMapping("/crowdfundings")
    public String mostrarHomeCrowdfunding(Model model){

        model.addAttribute("crowdfundings", crowdfundingService.obteneCrowdfunding());

        return "crowdfunding/homeCrowdfunding";
    }

    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    @PostMapping("/editCrowdfunding")
    public String guardarCrowdfunding(
            @RequestParam("nombreProyecto") String nombreProyecto,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("metaMonetaria") BigDecimal metaMonetaria,
            @RequestParam("formFile") MultipartFile formFile,
            Principal principal
            ) throws IOException {

        String email = principal.getName();

        // Buscar al usuario en la tabla empresario
        Empresario empresario = empresarioRepository.findByUsuarioCorreo(email)
            .orElseThrow(() -> new IllegalStateException("El usuario no está registrado como empresario"));

        // Crear una nueva instancia de Crowdfunding y asignar valores
        Crowdfunding crowdfunding = new Crowdfunding();
        crowdfunding.setTitulo(nombreProyecto);
        crowdfunding.setDescripcion(descripcion);
        crowdfunding.setMeta(metaMonetaria);
        crowdfunding.setRecaudado(BigDecimal.ZERO);  // Asumiendo que inicia en 0

        // Guardar la imagen en el directorio 'uploads'
        if (!formFile.isEmpty()) {
            String imageName = formFile.getOriginalFilename();
            Path imagePath = Paths.get(UPLOAD_DIR, imageName);
            Files.copy(formFile.getInputStream(), imagePath);

            // Establecer la ruta de la imagen en el objeto Crowdfunding
            crowdfunding.setMain_img("/uploads/" + imageName);
        }
        crowdfunding.setEmpresario(empresario);

        // Guardar la instancia de Crowdfunding en la base de datos
        crowdfundingRepo.save(crowdfunding);

        return "redirect:/crowdfundings";
    }
}
