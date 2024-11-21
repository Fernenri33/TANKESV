package com.app.tankesv.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    
    public Usuario() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(name="nombre", length = 100)
    @NotBlank(message = "El nombre completo es obligatorio")
    private String nombre;

    @Email(message = "Debe ingresar un correo electrónico válido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Column(name="correo", length = 100)
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Column(name="password", length = 100)
    private String password;

    @NotBlank(message = "La confirmación de la contraseña es obligatoria")
    private String confirmPassword;

    @NotBlank(message = "El número de teléfono es obligatorio")
    private String telefono;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @Column(name = "foto_perfil")
    private String fotoPerfil; 

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }


    public int getId_usuario() {
        return this.id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", correo=" + correo + ", password="
                + password + ", confirmPassword=" + confirmPassword + ", telefono=" + telefono + ", fechaNacimiento="
                + fechaNacimiento + ", direccion=" + direccion + ", fotoPerfil=" + fotoPerfil 
                + ", getConfirmPassword()=" + getConfirmPassword() + ", getTelefono()=" + getTelefono()
                + ", getFechaNacimiento()=" + getFechaNacimiento() + ", getDireccion()=" + getDireccion()
                + ", getClass()=" + getClass() + ", getFotoPerfil()=" + getFotoPerfil() + ", getId_usuario()="
                + getId_usuario() + ", getNombre()=" + getNombre() + ", getCorreo()=" + getCorreo() + ", getPassword()="
                + getPassword() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

    
    
}

