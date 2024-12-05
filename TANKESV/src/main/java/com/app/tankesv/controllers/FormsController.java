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

    @GetMapping("/login")
    public String mostrarLogin(){
        return "formularios/formLogin";
    }

    @GetMapping("/Pago")
    public String mostrarFormPagoFacturacion(){
        return "formularios/FormPagoFacturacion";
    }

    

    @GetMapping("/NuevoCliente")
    public String mostrarformRegistroClientes(){
        return "formularios/formRegistroClientes";
    }

    @GetMapping("/NuevoEmprendedor")
    public String mostrarformRegistroEmprendedores(){
        return "formularios/formRegistroEmprendedores";
    }

/*
 * El Controlador ReportarUsuario hasido movido a la carpeta formsController, por favor hacer lo mismo para cada controlador
 * Lo mueven A UNA CLASE INDIVIDUAL dentro de la carpeta formsController, ahí manejen TODA LA LOGICA de CADA FORMULARIO
 */

 @GetMapping("/ReportarUsuario")
 public String mostrarformReporteUsuario(){
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

    @GetMapping("/Catalogo")
    public String mostrarformCatalogoEmprendedor(){
        return "formularios/formCatalogoEmprendedor";
    }
}
