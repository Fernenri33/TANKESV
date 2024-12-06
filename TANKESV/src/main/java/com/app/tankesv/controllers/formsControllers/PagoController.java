package com.app.tankesv.controllers.formsControllers;

import com.app.tankesv.model.Crowdfunding;
import com.app.tankesv.model.Pago;
import com.app.tankesv.repo.CrowdfundingRepo;
import com.app.tankesv.repo.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private CrowdfundingRepo crowdfundingRepo;

    @GetMapping("/Pago/{id}")
    public String mostrarFormPagoFacturacion(@PathVariable Long id, Model model){

        Integer integerId = Math.toIntExact(id);

        Crowdfunding crowdfunding = crowdfundingRepo.findById(integerId)
        .orElse(null);

        if (crowdfunding == null) {
            // Si no existe, agregar un mensaje de error al modelo y redirigir a una página de error
            model.addAttribute("error", "El crowdfunding con ID " + id + " no existe.");
            return "error/error"; // Nombre de la vista de error
        }

        model.addAttribute("id", id);
        return "formularios/FormPagoFacturacion";
    }

    // Crear un nuevo pago con datos enviados desde un formulario
    @PostMapping("/Pago/{id}")
    public ResponseEntity<String> createPago(@ModelAttribute Pago pago,@PathVariable Long id) {

        Integer integerId = Math.toIntExact(id);
       
        Crowdfunding crowdfunding = crowdfundingRepo.findById(integerId)
            .orElseThrow(() -> new IllegalArgumentException("Crowdfunding no encontrado con el ID: " + integerId));

        pago.setCrowdfunding(crowdfunding);

        pagoRepository.save(pago);

        return ResponseEntity.status(HttpStatus.CREATED).body("Pago realizado con éxito.");
    }
}

