package com.app.tankesv.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.tankesv.model.Usuario;
import com.app.tankesv.repo.UsuarioRepo;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioRepo repo;

    @GetMapping("/usuario")
    public String usuario(Model model) {
        List<Usuario> usuarios = repo.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario";
    }

    @GetMapping("/homeUsuario")
    public String mostrarLogin(){
        return "/usuarioLogin";
    }

   

}