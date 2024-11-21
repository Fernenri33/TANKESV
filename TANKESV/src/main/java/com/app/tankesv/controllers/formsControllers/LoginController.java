package com.app.tankesv.controllers.formsControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.tankesv.model.Usuario;
import com.app.tankesv.repo.UsuarioRepo;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepo loginRepository;


    @PostMapping
    public String login(@RequestParam ("email") String correo,
                        @RequestParam("password") String password) {
        Usuario existingLogin = loginRepository.findByCorreo(correo);
        if (existingLogin != null && existingLogin.getPassword().equals(password)) {
            return "Inicio de sesión exitoso";
        } else {
            return "Credenciales incorrectas";
        }
    }
}
