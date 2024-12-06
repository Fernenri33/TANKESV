package com.app.tankesv.controllers.formsControllers;

import com.app.tankesv.model.Empresario;
import com.app.tankesv.repo.EmpresarioRepository;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpresarioController {

    @Autowired
    private EmpresarioRepository empresarioRepository;

    @PostMapping ("/Empresario")
    public String crearEmpresario(@ModelAttribute Empresario empresario, Principal principal) {
        
        String email = principal.getName();

        System.out.println(email);
        
        empresarioRepository.save(empresario);

        return "redirect:/homeUsuario";
 }
}




