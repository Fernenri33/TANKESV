package com.app.tankesv.controllers.crowdfundingControllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import com.app.tankesv.model.Crowdfunding;
import com.app.tankesv.model.Empresario;
import com.app.tankesv.repo.CrowdfundingRepo;
import com.app.tankesv.repo.EmpresarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Controller
public class MyCrowdfundingsController {

    @Autowired EmpresarioRepository empresarioRepository;
    @Autowired CrowdfundingRepo crowdfundingRepo;
    
    @GetMapping("/MisCrowdfundings")
    public String mostrarCrowdfunding(Model model, Principal principal){

        String email = principal.getName();
        Empresario empresario = empresarioRepository.findByUsuarioCorreo(email)
            .orElseThrow(() -> new IllegalStateException("El usuario no está registrado como empresario"));
        
            List<Crowdfunding> crowdfundingList = crowdfundingRepo.findByEmpresario_IdEmpresario(empresario.getIdEmpresario());

            model.addAttribute("crowdfundings", crowdfundingList);

        return "crowdfunding/dashboard";
    }

    @GetMapping("/editCrowdfunding/{id}")
    public String editarCrowdfunding(Model model, Principal principal,@PathVariable int id){
        
        String email = principal.getName();
        Empresario empresario = empresarioRepository.findByUsuarioCorreo(email).orElseThrow(() -> new IllegalStateException("El usuario no está registrado como empresario"));

        Crowdfunding crowdfunding = new Crowdfunding();
        crowdfunding = crowdfundingRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Crowdfunding no encontrado"));;
        
        try {
            if(crowdfunding.getEmpresario().getIdEmpresario() == empresario.getIdEmpresario()){
                model.addAttribute("crowdfunding", crowdfunding);
                return "crowdfunding/editCrowdfunding";
            }
        } catch (Exception e) {
            return "redirect:/homeUsuario";
        }
        return "redirect:/homeUsuario";
    }

    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    @PostMapping("/editCrowdfunding/{id}")
    public String saveCrowdfunding(
        @RequestParam("nombreProyecto") String nombreProyecto,
        @RequestParam("descripcion") String descripcion,
        @RequestParam("metaMonetaria") BigDecimal metaMonetaria,
        @RequestParam("formFile") MultipartFile formFile,
        @PathVariable int id)throws IOException{

        Crowdfunding crowdfunding = crowdfundingRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el crowdfunding con id: " + id));

        crowdfunding.setIdCrowdfunding(id);
        crowdfunding.setTitulo(nombreProyecto);
        crowdfunding.setMeta(metaMonetaria);
        crowdfunding.setDescripcion(descripcion);

        if(!formFile.isEmpty()){

            String imageName = formFile.getOriginalFilename();
            Path imagePath = Paths.get(UPLOAD_DIR, imageName);
            Files.copy(formFile.getInputStream(), imagePath);

            // Establecer la ruta de la imagen en el objeto Crowdfunding
            crowdfunding.setMain_img("/uploads/" + imageName);
        }

        crowdfundingRepo.save(crowdfunding);

        return "redirect:/crowdfundings";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCrowdfunding(@PathVariable int id, Principal principal) {
    // Obtener el correo del usuario autenticado
    String email = principal.getName();

    // Buscar al empresario por su correo
    Empresario empresario = empresarioRepository.findByUsuarioCorreo(email)
        .orElseThrow(() -> new IllegalStateException("El usuario no está registrado como empresario"));

    // Buscar el crowdfunding por su id
    Crowdfunding crowdfunding = crowdfundingRepo.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Crowdfunding no encontrado"));

    // Verificar que el crowdfunding pertenece al empresario
    if (crowdfunding.getEmpresario().getIdEmpresario() != empresario.getIdEmpresario()) {
        throw new IllegalStateException("No tiene permisos para eliminar este crowdfunding");
    }

    // Eliminar el crowdfunding
    crowdfundingRepo.delete(crowdfunding);

    // Redirigir de vuelta al dashboard
    return "redirect:/MisCrowdfundings";
}
}
