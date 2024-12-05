package com.app.tankesv.controllers.formsControllers;

import com.app.tankesv.model.Pago;
import com.app.tankesv.repo.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pagos") // Ruta base para este controlador
public class PagoController {

    @Autowired
    private PagoRepository pagoRepository;

    // Crear un nuevo pago con datos enviados desde un formulario
    @PostMapping
    public ResponseEntity<String> createPago(@ModelAttribute Pago pago) {
        // Validar que el objeto Crowdfunding no sea nulo
        if (pago.getCrowdfunding() == null || pago.getCrowdfunding().getIdCrowdfunding() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: El crowdfunding asociado no es válido.");
        }

        // Guardar el pago en la base de datos
        pagoRepository.save(pago);

        // Devolver un mensaje personalizado
        return ResponseEntity.status(HttpStatus.CREATED).body("Pago realizado con éxito.");
    }
}

