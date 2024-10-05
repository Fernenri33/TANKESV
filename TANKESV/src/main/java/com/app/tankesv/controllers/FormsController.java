package com.app.tankesv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormsController {

    @GetMapping("/AdminDeUsuario")
    public String mostrarformAdministracionDeUsuario(){
        return "formularios/formAdministracionDeUsuario";
    }

    @GetMapping("/Comentario")
    public String mostrarformComentarios(){
        return "formularios/formComentarios";
    }

    @GetMapping("/CreacionPerfil")
    public String mostrarformCreacionDePerfil(){
        return "formularios/formCreacionDePerfil";
    }

    @GetMapping("/CrearProyecto")
    public String mostrarformCreacionDeProyectos(){
        return "formularios/formCreacionDeProyectos";
    }
    
    @GetMapping("/GestionCatalogo")
    public String mostrarformGestionCatalogos(){
        return "formularios/formGestionCatalogos";
    }

    @GetMapping("/Login")
    public String mostrarLogin(){
        return "formularios/formLogin";
    }

    @GetMapping("/Pago")
    public String mostrarFormPagoFacturacion(){
        return "formularios/FormPagoFacturacion";
    }

    @GetMapping("/RecuperarContrasena")
    public String mostrarFormRecuperacionDeContraseña(){
        return "formularios/FormRecuperacionDeContraseña";
    }

    @GetMapping("/NuevoCliente")
    public String mostrarformRegistroClientes(){
        return "formularios/formRegistroClientes";
    }

    @GetMapping("/NuevoEmprendedor")
    public String mostrarformRegistroEmprendedores(){
        return "formularios/formRegistroEmprendedores";
    }

    @GetMapping("/ReportarUsuario")
    public String mostrarformReporteDeUsuarios(){
        return "formularios/formReporteDeUsuarios";
    }

    @GetMapping("/ReportarIncidente")
    public String mostrarformReporteIncidentess(){
        return "formularios/formReporteIncidentes";
    }

    @GetMapping("/Reportes")
    public String mostrarformReporteIncidentes(){
        return "formularios/formReportes";
    }
    // Estos son los controladores de Formularios
}
